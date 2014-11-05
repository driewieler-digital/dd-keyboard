package com.driewielerdigital.cordova.plugin;

	import android.util.Log;   

    import org.apache.cordova.CordovaPlugin;
    import org.apache.cordova.CallbackContext;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;
    
	import android.content.Context;    
	import android.app.Activity;	
    
	import android.view.View;
	import android.view.ViewGroup;	
	import android.graphics.Rect;
	
//  import com.phonegap.DroidGap;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;


    /**
     * This class implements a listener which calls Phonegap callbacks on the keyboard changes.
     */
    public class DDLayoutChangeListener implements View.OnLayoutChangeListener {
    
    	private CallbackContext callbackContext;
    	private String ID = "Cordova DDLayoutChangeListener";
/*    	public DDLayoutChangeListener(CallbackContext callbackContext1) {
    		this.callbackContext = callbackContext1;
    	}*/
    	// sets the callback for on keyboard change
    	public void setCallback(CallbackContext callbackContext1) {
    		this.callbackContext = callbackContext1;
    	}
				
					@Override
					public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom)
						{

							// the width minus screen decorations
							Rect outRect = new Rect();
							v.getWindowVisibleDisplayFrame(outRect);
							int h = outRect.height();
							int w = outRect.width();																			
							
							// the measured width
							int w2 = v.getMeasuredWidth();
							int h2 = v.getMeasuredHeight();			
							String message = "";
							
							if ( w2 != w || h2 != h ) {
								// keyboard is visible
								Log.d(this.ID, "Keyboard shown");
								message = "shown";

							}
							else {
								// keyboard not visible
								Log.d(this.ID, "Keyboard hidden");			
								message = "hidden";													
							}						
			
							if ( this.callbackContext != null ) {
								this.callbackContext.success(message);							
								}
							else {
								Log.d(this.ID, "no callback");
							}
							
						}

				}