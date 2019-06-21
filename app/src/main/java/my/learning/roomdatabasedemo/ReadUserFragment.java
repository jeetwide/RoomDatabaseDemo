package my.learning.roomdatabasedemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {


    private TextView txt_display_info;

    private RecyclerView mRecyclerView;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_read_user, container, false);

        txt_display_info = view.findViewById(R.id.txt_display_info);

        List<User> users= MainActivity.myAppDatabase.myDao().getUsers();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);


        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        String info="";

        ArrayList data = new ArrayList<User>();

        for(User usr: users){
            int id = usr.getId();
            String name = usr.getName();
            String email = usr.getEmail();
            data.add(usr);

            ListAdapter listAdapter=new ListAdapter(data);
            mRecyclerView.setAdapter(listAdapter);
            listAdapter.notifyDataSetChanged();


           // info = info + "\n\n"+"id: "+id+"\n Name : "+name+"\n"+"Email: "+email
           // +"\n id :"+id;

        }

        //txt_display_info.setText(info);

        return view;
    }

}
