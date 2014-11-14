package com.dls.annuairegabon;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.dls.annuairegabon.application.AnnuaireGabonApplication;
import com.dls.annuairegabon.views.fragments.AnnuaireGabonFragment;

/**
 * The Annuaire Gabon Main Activity
 * @author Damdoum
 */
public class AnnuaireGabonActivity extends ActionBarActivity {
	/** Tag for log event*/
	protected final String LOG_TAG = getClass().getSimpleName();

	/** The current application */
	private AnnuaireGabonApplication application;

	/** Navigation Drawer */
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	private ActionBarDrawerToggle drawerToggle;

	private CharSequence drawerTitle;
	private CharSequence title;
	private String[] navigationDrawerTitles;


	/**
	 * Called when the application is created
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(LOG_TAG, "OnCreate");

		// Set the main content view
		setContentView(R.layout.annuaire_gabon_layout);

		// Set the current application
		application = (AnnuaireGabonApplication) getApplication();

		// Navigation Drawer
		title = drawerTitle = getTitle();
		navigationDrawerTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
		drawerLayout = (DrawerLayout) findViewById(R.id.navigation_drawer_layout);
		drawerList = (ListView) findViewById(R.id.left_navigation_drawer);

		// Set a custom shadow that overlays the main content when the drawer opens
		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		// Set up the drawer's list view with items and click listener
		drawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, navigationDrawerTitles));
		drawerList.setOnItemClickListener(new NavigationDrawerItemClickListener());

		// enable ActionBar application icon to behave as action to toggle navigation drawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		// ActionBarDrawerToggle ties together the the proper interactions
		// between the sliding drawer and the action bar app icon
		drawerToggle = new ActionBarDrawerToggle(
				this,                  /* host Activity */
				drawerLayout,         /* DrawerLayout object */
				R.drawable.ic_drawer,  /* navigation drawer image to replace 'Up' caret */
				R.string.drawer_open,  /* "open drawer" description for accessibility */
				R.string.drawer_close  /* "close drawer" description for accessibility */
				) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(title);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(drawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
			}
		};
		drawerLayout.setDrawerListener(drawerToggle);

		// Show the home page
		if (savedInstanceState == null) {
			selectNavigationDrawerItem(0);
		}
	}

	// ----------------------------------------- Navigation Drawer management -----------------------------------------//
	/**
	 *  The click listener for ListView in the navigation drawer
	 */
	private class NavigationDrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			selectNavigationDrawerItem(position);
		}
	}

	/**
	 * Select an item in the navigation drawer
	 * @param position
	 */
	private void selectNavigationDrawerItem(int position) {
		// Update the main content by replacing fragments
		Fragment fragment = new AnnuaireGabonFragment();
		Bundle args = new Bundle();
		args.putInt(AnnuaireGabonFragment.ARG_ITEM_TITLE, position);
		fragment.setArguments(args);

		// Replace whatever is in the fragment_container view with this
		// fragment, and add the transaction to the back stack
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

		// Update selected item and title, then close the drawer
		drawerList.setItemChecked(position, true);
		setTitle(navigationDrawerTitles[position]);
		drawerLayout.closeDrawer(drawerList);
	}


	// ----------------------------------------- Action Bar management -----------------------------------------//
	/**
	 * Called when the options menu is opened
	 */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.annuaire_gabon_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /** 
     * Called whenever we call invalidateOptionsMenu()
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the navigation drawer is open,
    	// hide action items related to the content view
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        menu.findItem(R.id.action_item_search).setVisible(!drawerOpen);
        menu.findItem(R.id.action_item_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * Called when an action bar item is selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item)) 
            return true;

        // Handle action buttons
        switch(item.getItemId()) {
	        case R.id.action_item_search :
	        case R.id.action_item_settings :
	        	Toast.makeText(application, "Action unavailable now", Toast.LENGTH_SHORT).show();
	            return true;
	            
	        default:
	            return super.onOptionsItemSelected(item);
        }
    }
	
	/**
	 * Set the title in the action bar
	 */
	@Override
	public void setTitle(CharSequence title) {
		this.title = title;
		getActionBar().setTitle(title);
	}

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggles
        drawerToggle.onConfigurationChanged(newConfig);
    }


	// ----------------------------------------- Fragments management -----------------------------------------//
	//	/**
	//	 * Display the given fragment in the fragment container
	//	 * 
	//	 * @param fragment
	//	 *            the fragment to display
	//	 * @param fragmentId
	//	 *            an id for the fragment, to later retrieve it
	//	 */
	//	private void showFragment(Fragment fragment, int fragmentId, boolean shouldAddInBackStack) {
	//		Log.d(LOG_TAG, "showFragment");
	//
	//		// Replace whatever is in the fragment_container view with this
	//		// fragment, and add the transaction to the back stack
	//		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
	//		String fragmentTag = String.valueOf(fragmentId);
	//		if (shouldAddInBackStack)
	//			fragmentTransaction.addToBackStack(fragmentTag);
	//		
	//		fragmentTransaction.replace(R.id.fragmentContainer, fragment, fragmentTag);
	//		fragmentTransaction.commit();
	//
	//		// Change the action bar
	//		changeActionBar(fragmentId);
	//	}

	/**
	 * Clear the fragment manager
	 */
	//	@SuppressWarnings("unused")
	//	private void clearFragmentManager() {
	//		Log.d(LOG_TAG, "clearFragmentManager");
	//		FragmentManager fragmentManager = getSupportFragmentManager();
	//		for(int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {    
	//			fragmentManager.popBackStackImmediate();
	//		}		
	//	}

	/**
	 * Show the merchants list
	 */
	//	public void showMerchantsList(){
	//		Log.d(LOG_TAG, "showMerchantsList");
	//		// Initiate a new fragment
	//		MerchantsListFragment merchantsListFragment = new MerchantsListFragment();
	//
	//		// Set the current client and screen type in the application
	//		application.setCurrentScreenType(AnnuaireGabonScreenType.MERCHANTS_LIST_SCREEN_TYPE);
	//		application.setCurrentFragment(merchantsListFragment);
	//		
	//		// Show the login fragment
	//		this.showFragment(merchantsListFragment, R.id.fragmentMerchantsList, false);
	//	}
}
