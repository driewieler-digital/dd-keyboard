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
     * This class echoes a string called from JavaScript.
     */
    public class DDKeyboard extends CordovaPlugin {

		private String ID = "Cordova DDKeyboard";
		private DDLayoutChangeListener layout_listener = new DDLayoutChangeListener();
		private boolean listener_added = false;
	
        @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        	Log.d("Cordova", "Initialized");
            if (action.equals("hide")) {
                String message = args.getString(0);
				
                Log.d(this.ID, "Hiding keyboard...");
                	this.hideKeyBoard();
                	return true;
				}	
			else if (action.equals("listen")) {
				// add listener for events indicating keyboard activity
				Log.d(this.ID, "Setting layoutchangelistener on WebView");

				// then, change the callback of the listener to the updated one.
				this.layout_listener.setCallback(callbackContext);				
				// if we have no listener yet, add it.
				if ( !this.listener_added ) {
					View mAppView = this.getWebView();					
					mAppView.addOnLayoutChangeListener(this.layout_listener);	
					}

				
				return true;
				}
			
				
				
			return false;
			}
			
	// knows height of screen, and thus can tell if keyboard is 
			
		//// hides the keyboard.
		public void hideKeyBoard() {

				View mAppView = this.getWebView();
								
	            Context context = cordova.getActivity().getApplicationContext();                             			
				InputMethodManager mgr = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
				mgr.hideSoftInputFromWindow(mAppView.getWindowToken(), 0);
		}    

		// returns the phonegap webview.		
		private View getWebView() {
			View mAppView = ((View)cordova.getActivity().getWindow().getDecorView().getRootView());
			return mAppView;
		}



    }