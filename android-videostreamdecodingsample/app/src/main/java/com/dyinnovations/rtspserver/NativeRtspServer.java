package com.dyinnovations.rtspserver;

/**
 *  A helper class to invoke native methods
 */
public class NativeRtspServer {

    public static final String TAG = NativeRtspServer.class.getSimpleName();

    public static void init() {
        nativeInit();
    }

    //JNI

    /**
     * Initialize the rtsp_server.
     * @return
     */
    private static native void nativeInit();

    /**
     * Finalize the rtsp_server.
     * @return
     */
//    public native void nativeFinalize();

    /**
     * inject the data to rtsp_server
     * @param buf
     * @param size
     * @return
     */
    public static native void injectBuffer(byte[] buf, int size);

    static{
        System.loadLibrary("rtsp_server");
    }

    private static NativeRtspServer instance;

    public static NativeRtspServer getInstance() {
        if (instance == null) {
            instance = new NativeRtspServer();
        }
        return instance;
    }

    private NativeRtspServer() {
    }
}
