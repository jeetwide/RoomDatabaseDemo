package my.learning.roomdatabasedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button bt_add, bt_view,bt_delete,bt_update;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bt_add = view.findViewById(R.id.bt_add);
        bt_view = view.findViewById(R.id.bt_view);
        bt_delete = view.findViewById(R.id.bt_delete);
        bt_update = view.findViewById(R.id.bt_update);


        bt_add.setOnClickListener(this);
        bt_view.setOnClickListener(this);
        bt_delete.setOnClickListener(this);
        bt_update.setOnClickListener(this);

        return view;

        //return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bt_add:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AddUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.bt_view:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.bt_delete:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteUserFragment())
                        .addToBackStack(null).commit();
                break;

            case R.id.bt_update:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment())
                        .addToBackStack(null).commit();
                break;


        }

    }
}
