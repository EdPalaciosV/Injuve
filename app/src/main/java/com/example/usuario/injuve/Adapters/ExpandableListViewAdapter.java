package com.example.usuario.injuve.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.usuario.injuve.R;

import java.util.List;
import java.util.Map;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List <String> listTitle;
    private Map<String,List<String>>listItems;

    public ExpandableListViewAdapter(Context context,List<String> listTitle, Map<String, List<String>> listItems) {
        this.context=context;
        this.listTitle = listTitle;
        this.listItems = listItems;
    }

    @Override
    public int getGroupCount() {
        return listTitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listItems.get(listTitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listItems.get(listTitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        String title=(String)getGroup(groupPosition);
        if (view==null)
        {
            LayoutInflater inflater=LayoutInflater.from(context);
            view=inflater.inflate(R.layout.title_design_list,null);


        }
        TextView textViewTitle=view.findViewById(R.id.TVtitle);
        textViewTitle.setText(title);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {
       String child=(String)getChild(groupPosition,childPosition);
       if (view==null)
       {
           LayoutInflater inflater=LayoutInflater.from(context);
           view=inflater.inflate(R.layout.child_design_list,null);

       }
       TextView textViewChild=view.findViewById(R.id.TVchild);
       textViewChild.setText(child);
       return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
