package in.etuwa.app.ui.stationary;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.ui.stationary.booking.BookingFragment;
import in.etuwa.app.ui.stationary.bookinghistory.BookingHistoryFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StationaryMainAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class StationaryMainAdapter extends FragmentStatePagerAdapter {
    private final String[] heading;

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StationaryMainAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.heading = new String[]{"Pre Booking", "Previous Booking"};
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        if (position != 0) {
            return position != 1 ? fragment : BookingHistoryFragment.INSTANCE.newInstance();
        }
        return BookingFragment.INSTANCE.newInstance();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.heading.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.heading[position];
    }
}