package com.example.aepl.fragment_tab;

import android.app.ListFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by aepl on 27/6/16.
 */
public class ListBrands extends ListFragment {
    OnArticleSelectedListener onselectitem;
    public interface OnArticleSelectedListener {
         void onArticleSelected(int position);
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            onselectitem = (OnArticleSelectedListener)getActivity();

        }catch (Exception e){
            Toast.makeText(getActivity(),"Exception - onitemselected ",Toast.LENGTH_LONG).show();
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,BrandName.brand);
        setListAdapter(adapter);

        try{
            onselectitem = (OnArticleSelectedListener)getActivity();

        }catch (Exception e){
            Toast.makeText(getActivity(),"Exception - onitemselected ",Toast.LENGTH_LONG).show();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
         onselectitem.onArticleSelected(position);
    }
}
