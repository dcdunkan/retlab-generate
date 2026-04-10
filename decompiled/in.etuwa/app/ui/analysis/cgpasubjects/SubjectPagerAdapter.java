package in.etuwa.app.ui.analysis.cgpasubjects;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.ui.analysis.cgpasubjects.SemPagerFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubjectPagerAdapter.kt */
/* loaded from: classes4.dex */
public final class SubjectPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<ArrayList<AnalysisSubjectBean>> subject;
    private final String[] titleList;

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
    }

    public final ArrayList<ArrayList<AnalysisSubjectBean>> getSubject() {
        return this.subject;
    }

    public final void setSubject(ArrayList<ArrayList<AnalysisSubjectBean>> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.subject = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubjectPagerAdapter(FragmentManager manager, ArrayList<ArrayList<AnalysisSubjectBean>> subject) {
        super(manager, 1);
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(subject, "subject");
        this.subject = subject;
        this.titleList = new String[]{"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8"};
    }

    public final String[] getTitleList() {
        return this.titleList;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int position) {
        SemPagerFragment.Companion companion = SemPagerFragment.INSTANCE;
        ArrayList<AnalysisSubjectBean> arrayList = this.subject.get(position);
        Intrinsics.checkNotNullExpressionValue(arrayList, "subject[position]");
        return companion.newInstance(arrayList, position);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.subject.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.titleList[position];
    }
}