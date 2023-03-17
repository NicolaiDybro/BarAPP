package user.nicolai.barapp.SQL.BrugerInterface;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import user.nicolai.barapp.R;
import user.nicolai.barapp.SecondFragment;
import user.nicolai.barapp.databinding.FragmentBlankBinding;
import user.nicolai.barapp.databinding.FragmentLoginBinding;
import user.nicolai.barapp.databinding.FragmentSecondBinding;

public class LoginFragment extends Fragment {
    private static final String url = "jdbc:mysql://75.119.128.187:3306/barapp";
    private static final String user = "barapp";
    private static final String pass = "pTF]A1Ql@*_]t7TN";
    private FragmentLoginBinding binding;
    public void testDB() {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String result = "Database connection success\n";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from ari");
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()) {
                result += rsmd.getColumnName(1) + ": " + rs.getInt(1) + "\n";
                result += rsmd.getColumnName(2) + ": " + rs.getString(2) + "\n";
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testDB();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
