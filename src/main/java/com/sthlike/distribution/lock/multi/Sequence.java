/*
 * Copyright (c) 2020 sthlike.com.
 */

package com.sthlike.distribution.lock.multi;

import java.io.*;

public class Sequence {
    private static final String FILE_PATH = "//Users/sun/Downloads/sequence.txt";
    private static int sequence = 0;
    private ZkLock lock;

    public Sequence(ZkLock lock) {
        this.lock = lock;
    }

    public void writeSequenceToFile() {
        try {
            lock.lock();

            try (LineNumberReader lnr = new LineNumberReader(new FileReader(FILE_PATH));
                 FileWriter fw = new FileWriter(FILE_PATH, true)) {
                int lineNumber = 0;
                while (lnr.readLine() != null) {
                    lineNumber++;
                }
                fw.write(lineNumber + 1 + "\r\n");
                fw.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unLock();
        }
    }
}
