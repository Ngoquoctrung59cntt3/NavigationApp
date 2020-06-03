package vn.edu.ntu.navigationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListProduct_Fragment extends Fragment {
    FloatingActionButton fab;
    RecyclerView rvListMH;
    NavController controller;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.mnt_cart, menu);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_product, container, false);
        rvListMH = view.findViewById(R.id.rvListProduct);
        fab = view.findViewById(R.id.fab);
        return view;
    }// tra ve 1 view

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = NavHostFragment.findNavController(ListProduct_Fragment.this);
        ((MainActivity)getActivity()).controller = controller;
      /*  view.findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListProduct_Fragment.this)
                        .navigate(R.id.action_importProductFragment_to_listProduct_Fragment);
            }
        });*/

      fab.setOnClickListener(new View.OnClickListener()
      {
          @Override
          public void onClick(View v) {
              controller.navigate(R.id.action_listProduct_Fragment_to_importProductFragment);
          }
      });
    }
}
