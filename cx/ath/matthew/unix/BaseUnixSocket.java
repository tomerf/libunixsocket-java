/*
 * Java Unix Sockets Library
 *
 * Copyright (c) Matthew Johnson 2004
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * To Contact the author, please email src@matthew.ath.cx
 *
 */
package cx.ath.matthew.unix;

import java.io.IOException;

/**
 * Represents a listening UNIX Socket.
 */
public abstract class BaseUnixSocket
{
   static { System.loadLibrary("unix-java"); }
   protected native void native_close(int sock) throws IOException;
   protected UnixSocketAddress address = null;
   protected boolean closed = false;
   protected int sock;
   /**
    * Create an un-bound server socket.
    */
   public BaseUnixSocket()
   {
   }
   /**
    * Closes the ServerSocket.
    */
   public synchronized void close() throws IOException
   {
      native_close(sock);
      sock = 0;
      closed = true;
   }
   /**
    * Return the address this socket is bound to.
    * @return The UnixSocketAddress if bound or null if unbound.
    */
   public UnixSocketAddress getAddress()
   {
      return address;
   }
   /**
    * Check the status of the socket.
    * @return True if closed.
    */
   public boolean isClosed()
   {
      return closed;
   }
}
