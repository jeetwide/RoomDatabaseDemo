package my.learning.roomdatabasedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {


    private EditText et_id;
    private Button bt_delete;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.fragment_delete_user, container, false);;
        et_id=view.findViewById(R.id.et_id);
        bt_delete=view.findViewById(R.id.bt_delete);


        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userid= Integer.parseInt(et_id.getText().toString());
                User user = new User();
                user.setId(userid);
                MainActivity.myAppDatabase.myDao().deleteUser(user);

                Toast.makeText(getActivity(), "User Successfully Deleted ", Toast.LENGTH_SHORT).show();
                et_id.setText("");


            }
        });

        return view;
    }

}
