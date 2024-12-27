/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * THE FILE HAS BEEN AUTOGENERATED BY MSGTOOL TOOL.
 * All changes made to this file manually will be overwritten
 * if this tool runs again. Better make changes in the template file.
 */

package org.apache.commons.compress.harmony.archive.internal.nls;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;

//import org.apache.commons.compress.harmony.kernel.vm.VM;

/**
 * This class retrieves strings from a resource bundle and returns them, formatting them with MessageFormat when required.
 * <p>
 * It is used by the system classes to provide national language support, by looking up messages in the {@code
 *    org.apache.commons.compress.harmony.archive.internal.nls.messages
 * } resource bundle. Note that if this file is not available, or an invalid key is looked up, or resource bundle support is not available, the key itself
 * will be returned as the associated message. This means that the <em>KEY</em> should a reasonable human-readable (english) string.
 */
public class Messages {

    // ResourceBundle holding the system messages.
    private static ResourceBundle bundle;

    static {
        // Attempt to load the messages.
        try {
            bundle = setLocale(Locale.getDefault(), "org.apache.commons.compress.harmony.archive.internal.nls.messages"); //$NON-NLS-1$
        } catch (final Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates a formatted text string given a source string containing "argument markers" of the form "{argNum}" where each argNum must be in the range 0..9.
     * The result is generated by inserting the toString of each argument into the position indicated in the string.
     * <p>
     * To insert the "{" character into the output, use a single backslash character to escape it (i.e. "\{"). The "}" character does not need to be escaped.
     *
     * @param format String the format to use when printing.
     * @param args   Object[] the arguments to use.
     * @return String the formatted message.
     */
    public static String format(final String format, final Object[] args) {
        final StringBuilder answer = new StringBuilder(format.length() + args.length * 20);
        final String[] argStrings = new String[args.length];
        Arrays.setAll(argStrings, i -> Objects.toString(args[i], "<null>")); //$NON-NLS-1$
        int lastI = 0;
        for (int i = format.indexOf('{', 0); i >= 0; i = format.indexOf('{', lastI)) {
            if (i != 0 && format.charAt(i - 1) == '\\') {
                // It's escaped, just print and loop.
                if (i != 1) {
                    answer.append(format.substring(lastI, i - 1));
                }
                answer.append('{');
                lastI = i + 1;
            } else // It's a format character.
            if (i > format.length() - 3) {
                // Bad format, just print and loop.
                answer.append(format.substring(lastI));
                lastI = format.length();
            } else {
                final int argnum = (byte) Character.digit(format.charAt(i + 1), 10);
                if (argnum < 0 || format.charAt(i + 2) != '}') {
                    // Bad format, just print and loop.
                    answer.append(format.substring(lastI, i + 1));
                    lastI = i + 1;
                } else {
                    // Got a good one!
                    answer.append(format.substring(lastI, i));
                    if (argnum >= argStrings.length) {
                        answer.append("<missing argument>"); //$NON-NLS-1$
                    } else {
                        answer.append(argStrings[argnum]);
                    }
                    lastI = i + 3;
                }
            }
        }
        if (lastI < format.length()) {
            answer.append(format.substring(lastI));
        }
        return answer.toString();
    }

    /**
     * Retrieves a message which has no arguments.
     *
     * @param msg String the key to look up.
     * @return String the message for that key in the system message bundle.
     */
    public static String getString(final String msg) {
        if (bundle == null) {
            return msg;
        }
        try {
            return bundle.getString(msg);
        } catch (final MissingResourceException e) {
            return "Missing message: " + msg; //$NON-NLS-1$
        }
    }

    /**
     * Retrieves a message which takes 1 character argument.
     *
     * @param msg String the key to look up.
     * @param arg char the character to insert in the formatted output.
     * @return String the message for that key in the system message bundle.
     */
    public static String getString(final String msg, final char arg) {
        return getString(msg, new Object[] { String.valueOf(arg) });
    }

    /**
     * Retrieves a message which takes 1 integer argument.
     *
     * @param msg String the key to look up.
     * @param arg int the integer to insert in the formatted output.
     * @return String the message for that key in the system message bundle.
     */
    public static String getString(final String msg, final int arg) {
        return getString(msg, new Object[] { Integer.toString(arg) });
    }

    /**
     * Retrieves a message which takes 1 argument.
     *
     * @param msg String the key to look up.
     * @param arg Object the object to insert in the formatted output.
     * @return String the message for that key in the system message bundle.
     */
    public static String getString(final String msg, final Object arg) {
        return getString(msg, new Object[] { arg });
    }

    /**
     * Retrieves a message which takes 2 arguments.
     *
     * @param msg  String the key to look up.
     * @param arg1 Object an object to insert in the formatted output.
     * @param arg2 Object another object to insert in the formatted output.
     * @return String the message for that key in the system message bundle.
     */
    public static String getString(final String msg, final Object arg1, final Object arg2) {
        return getString(msg, new Object[] { arg1, arg2 });
    }

    /**
     * Retrieves a message which takes several arguments.
     *
     * @param msg  String the key to look up.
     * @param args Object[] the objects to insert in the formatted output.
     * @return String the message for that key in the system message bundle.
     */
    public static String getString(final String msg, final Object[] args) {
        String format = msg;

        if (bundle != null) {
            try {
                format = bundle.getString(msg);
            } catch (final MissingResourceException ignored) {
                // ignored
            }
        }

        return format(format, args);
    }

    /**
     * Changes the locale of the messages.
     *
     * @param locale   Locale the locale to change to.
     * @param resource resource name.
     * @return The ResourceBundle.
     */
    public static ResourceBundle setLocale(final Locale locale, final String resource) {
        try {
            // VM.bootCallerClassLoader() returns null
            final ClassLoader loader = null; // VM.bootCallerClassLoader();
            return (ResourceBundle) AccessController.doPrivileged(
                    (PrivilegedAction<Object>) () -> ResourceBundle.getBundle(resource, locale, loader != null ? loader : ClassLoader.getSystemClassLoader()));
        } catch (final MissingResourceException ignored) {
            // ignored
        }
        return null;
    }
}
