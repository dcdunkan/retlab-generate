package in.etuwa.app.ui.dashboard.dashtable;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.ui.dashboard.DashboardFragment;
import in.etuwa.app.ui.dashboard.dashtable.DashTableViewFragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DashTimeTableAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DashTimeTableAdapter extends FragmentStatePagerAdapter {
    private String date;
    private ArrayList<String> dates;
    private Integer id;
    private ArrayList<TimeTableNewResponse> list;
    private in.etuwa.app.ui.timetable.TimetableListener listener;
    private ArrayList<String> title2;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object object) {
        Intrinsics.checkNotNullParameter(object, "object");
        return -2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DashTimeTableAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.title2 = new ArrayList<>();
        this.dates = new ArrayList<>();
        this.list = new ArrayList<>();
    }

    public final ArrayList<String> getTitle2() {
        return this.title2;
    }

    public final void setTitle2(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.title2 = arrayList;
    }

    public final ArrayList<String> getDates() {
        return this.dates;
    }

    public final void setDates(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.dates = arrayList;
    }

    public final ArrayList<TimeTableNewResponse> getList() {
        return this.list;
    }

    public final void setList(ArrayList<TimeTableNewResponse> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        this.date = str;
    }

    public final Integer getId() {
        return this.id;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        DashTableViewFragment.Companion companion = DashTableViewFragment.INSTANCE;
        ArrayList<PeriodsNew> sub = this.list.get(position).getSub();
        String str = this.title2.get(position);
        Intrinsics.checkNotNullExpressionValue(str, "title2[position]");
        String str2 = str;
        String str3 = this.date;
        Intrinsics.checkNotNull(str3);
        Integer num = this.id;
        Intrinsics.checkNotNull(num);
        return companion.newInstance(sub, str2, str3, num.intValue(), position == 0, position == this.list.size() - 1);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        String str = this.title2.get(position);
        Intrinsics.checkNotNullExpressionValue(str, "title2[position]");
        return str;
    }

    public final void addItems(ArrayList<TimeTableNewResponse> tables, ArrayList<String> list2, String date, int id) {
        Intrinsics.checkNotNullParameter(tables, "tables");
        Intrinsics.checkNotNullParameter(list2, "list2");
        Intrinsics.checkNotNullParameter(date, "date");
        this.id = Integer.valueOf(id);
        this.date = date;
        this.title2.clear();
        this.list.clear();
        notifyDataSetChanged();
        this.title2.addAll(list2);
        this.list.addAll(tables);
        notifyDataSetChanged();
    }

    public final void clearData() {
        this.title2.clear();
        this.dates.clear();
        this.list.clear();
        notifyDataSetChanged();
    }

    public final void setCallBack(DashboardFragment context) {
        this.listener = context;
    }

    public final int getTodayIndex() {
        Integer numValueOf = Integer.valueOf(this.dates.indexOf(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date())));
        if (!(numValueOf.intValue() >= 0)) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        return 0;
    }
}