    /********* Echo.m Cordova Plugin Implementation *******/

    #import "DDSimpleEcho.h"
    #import <Cordova/CDV.h>
    
    #import <Foundation/Foundation.h>
    #import <UIKit/UIKit.h>    

    @implementation DDSimpleEcho

    - (void)echo:(CDVInvokedUrlCommand*)command
    {
        CDVPluginResult* pluginResult = nil;
        NSString* echo = [command.arguments objectAtIndex:0];

        if (echo != nil && [echo length] > 0) {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];
        } else {
            pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
        }

        [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
    }

    @end