// ILocationService.aidl
package com.example.locationservice;

// Declare any non-default types here with import statements

interface ILocationService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    float getLatitude();
    float getLongitude();
    float getDistance();
    float getAverageSpeed();
}
