/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>

/* Header for class cx_ath_matthew_unix_BaseUnixSocket */
#ifndef _Included_cx_ath_matthew_unix_UnixServerSocket
#define _Included_cx_ath_matthew_unix_UnixServerSocket
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     cx_ath_matthew_unix_BaseUnixSocket
 * Method:    native_close
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_cx_ath_matthew_unix_BaseUnixSocket_native_1close
  (JNIEnv *, jobject, jint);

#ifdef __cplusplus
}
#endif
#endif

/* Header for class cx_ath_matthew_unix_UnixUdpSocket */
#ifndef _Included_cx_ath_matthew_unix_UnixServerSocket
#define _Included_cx_ath_matthew_unix_UnixServerSocket
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     cx_ath_matthew_unix_UnixUdpSocket
 * Method:    native_bind
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_UnixUdpSocket_native_1bind
  (JNIEnv *env, jobject o, jstring address, jboolean abstract);

/*
 * Class:     cx_ath_matthew_unix_UnixUdpSocket
 * Method:    native_connect
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_UnixUdpSocket_native_1connect
  (JNIEnv *env, jobject o, jint sock, jstring address, jboolean abstract);

/*
 * Class:     cx_ath_matthew_unix_UnixUdpSocket
 * Method:    native_recv
 * Signature: ([BII)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_UnixUdpSocket_native_1recv
  (JNIEnv *env, jobject o, jint sock, jbyteArray buf, jint offs, jint len);

/*
 * Class:     cx_ath_matthew_unix_UnixUdpSocket
 * Method:    native_send
 * Signature: ([BII)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_UnixUdpSocket_native_1send
  (JNIEnv *env, jobject o, jint sock, jbyteArray buf, jint offs, jint len);

#ifdef __cplusplus
}
#endif
#endif

/* Header for class cx_ath_matthew_unix_UnixServerSocket */
#ifndef _Included_cx_ath_matthew_unix_UnixServerSocket
#define _Included_cx_ath_matthew_unix_UnixServerSocket
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     cx_ath_matthew_unix_UnixServerSocket
 * Method:    native_bind
 * Signature: (Ljava/lang/String;Z)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_UnixServerSocket_native_1bind
  (JNIEnv *, jobject, jstring, jboolean);

/*
 * Class:     cx_ath_matthew_unix_UnixServerSocket
 * Method:    native_accept
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_UnixServerSocket_native_1accept
  (JNIEnv *, jobject, jint);

#ifdef __cplusplus
}
#endif
#endif

/* Header for class cx_ath_matthew_unix_UnixSocket */
#ifndef _Included_cx_ath_matthew_unix_UnixSocket
#define _Included_cx_ath_matthew_unix_UnixSocket
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     cx_ath_matthew_unix_UnixSocket
 * Method:    native_set_pass_cred
 * Signature: (IZ)V
 */
JNIEXPORT void JNICALL Java_cx_ath_matthew_unix_UnixSocket_native_1set_1pass_1cred
  (JNIEnv *, jobject, jint, jboolean);

/*
 * Class:     cx_ath_matthew_unix_UnixSocket
 * Method:    native_connect
 * Signature: (Ljava/lang/String;Z)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_UnixSocket_native_1connect
  (JNIEnv *, jobject, jstring, jboolean);

#ifdef __cplusplus
}
#endif
#endif

/* Header for class cx_ath_matthew_unix_USInputStream */
#ifndef _Included_cx_ath_matthew_unix_USInputStream
#define _Included_cx_ath_matthew_unix_USInputStream
#ifdef __cplusplus
extern "C" {
#endif
#undef cx_ath_matthew_unix_USInputStream_SKIP_BUFFER_SIZE
#define cx_ath_matthew_unix_USInputStream_SKIP_BUFFER_SIZE 2048L
/*
 * Class:     cx_ath_matthew_unix_USInputStream
 * Method:    native_recv
 * Signature: (I[BII)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_USInputStream_native_1recv
  (JNIEnv *, jobject, jint, jbyteArray, jint, jint);

#ifdef __cplusplus
}
#endif
#endif

/* Header for class cx_ath_matthew_unix_USOutputStream */
#ifndef _Included_cx_ath_matthew_unix_USOutputStream
#define _Included_cx_ath_matthew_unix_USOutputStream
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     cx_ath_matthew_unix_USOutputStream
 * Method:    native_send
 * Signature: (I[BII)I
 */
JNIEXPORT jint JNICALL Java_cx_ath_matthew_unix_USOutputStream_native_1send
  (JNIEnv *, jobject, jint, jbyteArray, jint, jint);

#ifdef __cplusplus
}
#endif
#endif
