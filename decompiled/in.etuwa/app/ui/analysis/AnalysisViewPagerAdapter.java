package in.etuwa.app.ui.analysis;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisViewPagerAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnalysisViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList;
    private final String[] titleList;

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnalysisViewPagerAdapter(FragmentManager manager) {
        super(manager);
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.fragmentList = new ArrayList();
        this.titleList = new String[]{"CGPA", "Attendance", "Academic Progress"};
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        return this.fragmentList.get(position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.fragmentList.size();
    }

    public final void addFragment(List<Fragment> fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragmentList.clear();
        this.fragmentList.addAll(fragment);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.titleList[position];
    }
}