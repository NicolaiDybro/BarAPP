package user.nicolai.barapp;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.BreakIterator;
import java.util.Set;
import java.util.UUID;

import user.nicolai.barapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {


    public BluetoothAdapter bluetoothAdapter;
    private FragmentFirstBinding binding;
    ThreadConnectBTdevice myThreadConnectBTdevice;
    public static ThreadConnected myThreadConnected;
    public Set<BluetoothDevice> pairedDevices;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
      binding = FragmentFirstBinding.inflate(inflater, container, false);
      return binding.getRoot();
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            public void onClick(View view) {
                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(enableAdapter);
                pairedDevices = bluetoothAdapter.getBondedDevices();
                for (BluetoothDevice device : pairedDevices) {
                    System.out.println(device.getName() + ": " + device.getAddress());
                    if (device.getName().contains("raspberrypi")) {
                        if (myThreadConnected == null) {
                            myThreadConnectBTdevice = new ThreadConnectBTdevice(device);
                            myThreadConnectBTdevice.start();
                            NavHostFragment.findNavController(FirstFragment.this)
                                    .navigate(R.id.action_FirstFragment_to_blankFragment);

                        }
                    }
                }
            }
        });
    }


    public void startThreadConnected(BluetoothSocket socket) {
        ThreadConnected threadConnected = new ThreadConnected(socket);
        myThreadConnected = threadConnected;
        threadConnected.start();
    }

    public static class ThreadConnected extends Thread {
        private final BluetoothSocket connectedBluetoothSocket;
        private final InputStream connectedInputStream;
        private final OutputStream connectedOutputStream;

        public ThreadConnected(BluetoothSocket socket) {
            this.connectedBluetoothSocket = socket;
            InputStream in = null;
            OutputStream out = null;
            try {
                in = socket.getInputStream();
                out = socket.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.connectedInputStream = in;
            this.connectedOutputStream = out;
        }

        public void run() {
            byte[] buffer = new byte[1024];
            int bytes;
            while (true) try {
                try {
                    bytes = connectedInputStream.read(buffer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                String strReceived = new String(buffer, 0, bytes);
                final String msgReceived = String.valueOf(bytes) +
                        " bytes received:\n"
                        + strReceived;
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }

        public void write(byte[] buffer) {
            try {
                this.connectedOutputStream.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void cancel() {
            try {
                this.connectedBluetoothSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public class ThreadConnectBTdevice extends Thread{
        private BluetoothSocket bluetoothSocket;
        private final BluetoothDevice bluetoothDevice;


        ThreadConnectBTdevice(BluetoothDevice device) {
            bluetoothDevice = device;
            try {
                bluetoothSocket = (BluetoothSocket) this.bluetoothDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE).invoke(this.bluetoothDevice, new Object[]{1});
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        @SuppressLint("MissingPermission")
        public void run() {
            boolean success = false;
            try {
                bluetoothSocket.connect();
                success = true;
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    bluetoothSocket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            if (success) {
                startThreadConnected(bluetoothSocket);
                System.out.println("Connected to: " + this.bluetoothDevice.getName());
                return;
            }
            System.out.println("FEJL!!");
        }

    }

}