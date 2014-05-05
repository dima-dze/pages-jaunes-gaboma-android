package com.dls.annuairegabon.application;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.dls.annuairegabon.enums.AnnuaireGabonScreenType;

/**
 * The Annuaire Gabon Application
 * @author Damdoum
 */
public class AnnuaireGabonApplication extends Application {
	/** Tag for log event*/
	private final String LOG_TAG = getClass().getSimpleName();
	
	/** Empty String */
	public final String EMPTY_STRING = "";
	
	/** Current context & activity */
	private static Context context;
	
	/** Current Screen Type & Fragment */
	private AnnuaireGabonScreenType currentScreenType;
	private Fragment currentFragment;

	/**
	 * On create activity
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(LOG_TAG, "On Create");
		
		// Instantiate the context
		context = getApplicationContext();
	}

	// ----------------------------------------- Getters & Setters -----------------------------------------//
	/**
	 * Get the current Screen Type
	 * @return AnnuaireGabonScreenType
	 */
	public AnnuaireGabonScreenType getCurrentScreenType(){
		return this.currentScreenType;
	}
	
	/**
	 * Set the currentScreenType
	 * @param newScreenType
	 */
	public void setCurrentScreenType(AnnuaireGabonScreenType newScreenType) {
		this.currentScreenType = newScreenType;
	}
	
	/**
	 * Get the current fragment
	 * @return current fragment
	 */
	public Fragment getCurrentFragment(){
		return this.currentFragment;
	}

	/**
	 * Set the current Fragment
	 * @param newFragment
	 */
	public void setCurrentFragment(Fragment newFragment) {
		this.currentFragment = newFragment;
	}
}
