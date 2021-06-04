//
// ========================================================================
// Copyright (c) 1995-2021 Mort Bay Consulting Pty Ltd and others.
//
// This program and the accompanying materials are made available under the
// terms of the Eclipse Public License v. 2.0 which is available at
// https://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
// which is available at https://www.apache.org/licenses/LICENSE-2.0.
//
// SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
// ========================================================================
//

package org.eclipse.jetty.websocket.api.annotations;

import java.io.Reader;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.jetty.websocket.api.Session;

/**
 * Annotation for tagging methods to receive Binary or Text Message events.
 * <p>
 * Acceptable method patterns.<br>
 * Note: {@code methodName} can be any name you want to use.
 * <p>
 * <u>Text Message Versions</u>
 * <ol>
 * <li><code>public void methodName(String text)</code></li>
 * <li><code>public void methodName({@link Session} session, String text)</code></li>
 * <li><code>public void methodName(Reader reader)</code></li>
 * <li><code>public void methodName({@link Session} session, Reader reader)</code></li>
 * </ol>
 * <p>Note: that the {@link Reader} in this case will always use UTF-8 encoding/charset (this is dictated by the RFC 6455 spec for Text Messages. If you need to
 * use a non-UTF-8 encoding/charset, you are instructed to use the binary messaging techniques.</p><br>
 * <u>Binary Message Versions</u>
 * <ol>
 * <li><code>public void methodName(ByteBuffer message)</code></li>
 * <li><code>public void methodName({@link Session} session, ByteBuffer message)</code></li>
 * <li><code>public void methodName(byte buf[], int offset, int length)</code></li>
 * <li><code>public void methodName({@link Session} session, byte buf[], int offset, int length)</code></li>
 * <li><code>public void methodName(InputStream stream)</code></li>
 * <li><code>public void methodName({@link Session} session, InputStream stream)</code></li>
 * </ol>
 * <u>Partial Message Variations</u>
 * <p>These are used to receive partial messages without aggregating them into a complete WebSocket message. Instead the a boolean
 * argument is supplied to indicate whether this is the last segment of data of the message. This can be done most efficiently
 * for the {@link java.nio.ByteBuffer} type as no copying needs to occur to get the data into this format.</p>
 * <ol>
 * <li><code>public void methodName(ByteBuffer payload, boolean last)</code></li>
 * <li><code>public void methodName(byte payload, boolean last)</code></li>
 * <li><code>public void methodName(String payload, boolean last)</code></li>
 * </ol>
 * <p>Note: Similar to the signatures above these can all be used with an optional first {@link Session} parameter.</p>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value =
    {ElementType.METHOD})
public @interface OnWebSocketMessage
{
    /* no config */
}
