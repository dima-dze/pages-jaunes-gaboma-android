package com.dls.annuairegabon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.dls.annuairegabon.application.AnnuaireGabonApplication;
import com.dls.annuairegabon.enums.AnnuaireGabonScreenType;
import com.dls.annuairegabon.views.fragments.MerchantsListFragment;

public class AnnuaireGabonActivity extends ActionBarActivity {
	/** Tag for log event*/
	protected final String LOG_TAG = getClass().getSimpleName();

	/** The current application */
	private AnnuaireGabonApplication application;

	/**
	 * Called when the application is created
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set the main content view
		setContentView(R.layout.annuaire_gabon_layout);
		
		// Set the current application
		application = (AnnuaireGabonApplication) getApplication();
		
		// Show the first view
		showMerchantsList();
	}

	// ----------------------------------------- Fragments management -----------------------------------------//
	/**
	 * Display the given fragment in the fragment container
	 * 
	 * @param fragment
	 *            the fragment to display
	 * @param fragmentId
	 *            an id for the fragment, to later retrieve it
	 */
	private void showFragment(Fragment fragment, int fragmentId, boolean shouldAddInBackStack) {
		Log.d(LOG_TAG, "showFragment");

		// Replace whatever is in the fragment_container view with this
		// fragment, and add the transaction to the back stack
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		String fragmentTag = String.valueOf(fragmentId);
		if (shouldAddInBackStack)
			fragmentTransaction.addToBackStack(fragmentTag);
		
		fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragmentTag);
		fragmentTransaction.commit();

		// Change the action bar
		changeActionBar(fragmentId);
	}

	/**
	 * Clear the fragment manager
	 */
	@SuppressWarnings("unused")
	private void clearFragmentManager() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		for(int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {    
			fragmentManager.popBackStackImmediate();
		}		
	}

	/**
	 * Show the merchants list
	 */
	public void showMerchantsList(){
		// Initiate a new fragment
		MerchantsListFragment merchantsListFragment = new MerchantsListFragment();

		// Set the current client and screen type in the application
		application.setCurrentScreenType(AnnuaireGabonScreenType.MERCHANTS_LIST_SCREEN_TYPE);
		application.setCurrentFragment(merchantsListFragment);
		
		// Show the login fragment
		this.showFragment(merchantsListFragment, R.id.fragmentMerchantsList, false);
	}
	
	// ----------------------------------------- Action bar management -----------------------------------------//
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.annuaire_gabon, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	/**
	 * Change the action bar based on the shown fragment
	 * @param fragmentId
	 */
	public void changeActionBar(int fragmentId){
		//TODO remplir en fonction des ecrans
	}
}
