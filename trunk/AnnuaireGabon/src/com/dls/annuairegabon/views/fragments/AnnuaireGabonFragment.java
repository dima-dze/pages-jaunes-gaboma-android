package com.dls.annuairegabon.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dls.annuairegabon.R;

/**
 * Fragment that appears in the "content_frame"
 */
public class AnnuaireGabonFragment extends Fragment {
	/** Tag for log event*/
	protected final String LOG_TAG = getClass().getSimpleName();
	
	//FIXME Just for test
    public static final String ARG_ITEM_TITLE = "item_title";
    private RelativeLayout layout;
    private TextView textView;

    public AnnuaireGabonFragment() {
        // Empty constructor required for fragment subclasses
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	layout = (RelativeLayout) inflater.inflate(R.layout.fragment_annuaire_gabon, container, false);
        int i = getArguments().getInt(ARG_ITEM_TITLE);
        String itemTitle = getResources().getStringArray(R.array.navigation_drawer_items_array)[i];
        getActivity().setTitle(itemTitle);
        textView = (TextView) layout.findViewById(R.id.hello_world_text_view);
        textView.setText(itemTitle);

        return layout;
    }
}