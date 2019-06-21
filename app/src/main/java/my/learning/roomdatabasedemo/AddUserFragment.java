package my.learning.roomdatabasedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment implements View.OnClickListener{

    private EditText et_userid,et_name,et_email;
    Button bt_save;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_add_user, container, false);
        et_userid=view.findViewById(R.id.et_userid);
        et_name=view.findViewById(R.id.et_name);
        et_email=view.findViewById(R.id.et_email);
        bt_save=view.findViewById(R.id.bt_save);

        bt_save.setOnClickListener(this);

        return  view;
        //return inflater.inflate(R.layout.fragment_add_user, container, false);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.bt_save:
                int userid= Integer.parseInt(et_userid.getText().toString());
                String username = et_name.getText().toString();
                String useremail = et_email.getText().toString();

                User user= new User();
                user.setEmail(useremail);
                user.setName(username);
                user.setId(userid);
                
                MainActivity.myAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User Added Successfully", Toast.LENGTH_SHORT).show();

                et_name.setText("");
                et_email.setText("");
                et_userid.setText("");


        }

    }
}
