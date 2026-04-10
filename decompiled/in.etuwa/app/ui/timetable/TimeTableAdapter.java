package in.etuwa.app.ui.timetable;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.data.model.timetable.TimeTablePeriod;
import in.etuwa.app.ui.timetable.tableview.TimetableViewFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimeTableAdapter.kt */
/* loaded from: classes5.dex */
public final class TimeTableAdapter extends FragmentStatePagerAdapter {
    private ArrayList<TimeTablePeriod> list;
    private TimetableListener listener;
    private final String[] title;

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeTableAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.title = new String[]{"M", "T", ExifInterface.LONGITUDE_WEST, "T", "F", "S", "S"};
        this.list = new ArrayList<>();
    }

    public final String[] getTitle() {
        return this.title;
    }

    public final ArrayList<TimeTablePeriod> getList() {
        return this.list;
    }

    public final void setList(ArrayList<TimeTablePeriod> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        return TimetableViewFragment.INSTANCE.newInstance(this.list.get(position).getSub());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.title[position];
    }

    public final void addItems(ArrayList<TimeTablePeriod> tables) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        this.list.clear();
        this.list.addAll(tables);
        notifyDataSetChanged();
        TimetableListener timetableListener = this.listener;
        if (timetableListener != null) {
            timetableListener.loadPage();
        }
    }

    public final void setCallBack(TimeTableFragment context) {
        this.listener = context;
    }
}