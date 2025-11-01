package in.etuwa.app.ui.dashboard.dashtable;

import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.data.model.timetable.TimeTablePeriod;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.ui.timetable.TimetableListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DashTimeTableAdapter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0015\u001a\u00020\u00162\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ \u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010&R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lin/etuwa/app/ui/dashboard/dashtable/DashTimeTableAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/timetable/TimeTablePeriod;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/timetable/TimetableListener;", "title", "", "", "getTitle", "()[Ljava/lang/String;", "[Ljava/lang/String;", "addItems", "", "tables", "destroyItem", "container", "Landroid/view/ViewGroup;", CommonCssConstants.POSITION, "", "object", "", "getCount", "getItem", "Landroidx/fragment/app/Fragment;", "getPageTitle", "", "setCallBack", "context", "Lin/etuwa/app/ui/dashboard/DashboardFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DashTimeTableAdapter extends FragmentStatePagerAdapter {
    private ArrayList<TimeTablePeriod> list;
    private TimetableListener listener;
    private final String[] title;

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashTimeTableAdapter(FragmentManager fm) {
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
        return DashTableViewFragment.INSTANCE.newInstance(this.list.get(position).getSub());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        System.out.println(position);
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

    public final void setCallBack(DashboardFragment context) {
        this.listener = context;
    }
}