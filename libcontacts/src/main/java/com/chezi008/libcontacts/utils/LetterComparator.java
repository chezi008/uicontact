package com.chezi008.libcontacts.utils;

import android.util.Log;

import com.chezi008.libcontacts.bean.IndexBean;

import java.util.Comparator;

public class LetterComparator implements Comparator<IndexBean> {

    private static final String TAG = "LetterComparator";
    @Override
    public int compare(IndexBean l, IndexBean r) {
        if (l == null || r == null) {
            return 0;
        }
        if (l.getIndex() <= 0 && r.getIndex() <= 0) {
            Log.d(TAG, "compare: -->");
        } else if(l.getIndex() >0 && r.getIndex() >0) {
            int result = l.getIndex() - r.getIndex();
            Log.d(TAG, "compare: "+l.getLetter()+",rletter:"+r.getLetter()+",result:"+result);
            if (result > 0) {
                return 1;
            }
            if (result == 0) {
                return result;
            }
            if (result < 0) {
                return -1;
            }
        }else {
            int result = l.getIndex() - r.getIndex();
            if (result > 0) {
                return -1;
            }
            if (result == 0) {
                return result;
            }
            if (result < 0) {
                return 1;
            }
        }

        String lhsSortLetters = l.getLetter();
        String rhsSortLetters = r.getLetter();
        if (lhsSortLetters == null || rhsSortLetters == null) {
            return 0;
        }
        return lhsSortLetters.compareTo(rhsSortLetters);
    }
}