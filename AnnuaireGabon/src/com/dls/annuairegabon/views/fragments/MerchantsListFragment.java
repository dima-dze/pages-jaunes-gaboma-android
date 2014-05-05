package com.dls.annuairegabon.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dls.annuairegabon.R;

/**
 * The fragment of list of merchants
 * @author Damdoum
 */
public class MerchantsListFragment extends Fragment{
	/** Tag for log event */
	protected final String LOG_TAG = getClass().getSimpleName();
	
	/** UI elements */
	private RelativeLayout layout;
	
	

	/**
	 * Initialize the fragment view
	 */
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		this.layout = (RelativeLayout) inflater.inflate(R.layout.merchants_list_layout, null);
		
		
		return layout;
	}
}
