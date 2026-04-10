package in.etuwa.app.ui.attendance.bysubject;

import android.icu.util.Calendar;
import kotlin.Metadata;

/* JADX INFO: compiled from: CacheUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CacheUtils {
    public static final CacheUtils INSTANCE = new CacheUtils();

    private CacheUtils() {
    }

    public final boolean isSameDay(long timestamp) {
        if (timestamp == 0) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public final boolean isCacheValid(long timestamp) {
        return isSameDay(timestamp);
    }

    public final boolean isCacheValidForDuration(long savedTime, long durationMillis) {
        return savedTime != 0 && System.currentTimeMillis() - savedTime < durationMillis;
    }
}