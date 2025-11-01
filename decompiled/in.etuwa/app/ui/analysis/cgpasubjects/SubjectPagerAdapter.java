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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012,\u0010\u0004\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007`\u0007¢\u0006\u0002\u0010\bJ \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R@\u0010\u0004\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lin/etuwa/app/ui/analysis/cgpasubjects/SubjectPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "manager", "Landroidx/fragment/app/FragmentManager;", "subject", "Ljava/util/ArrayList;", "Lin/etuwa/app/ui/analysis/cgpasubjects/AnalysisSubjectBean;", "Lkotlin/collections/ArrayList;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/ArrayList;)V", "getSubject", "()Ljava/util/ArrayList;", "setSubject", "(Ljava/util/ArrayList;)V", "titleList", "", "", "getTitleList", "()[Ljava/lang/String;", "[Ljava/lang/String;", "destroyItem", "", "container", "Landroid/view/ViewGroup;", CommonCssConstants.POSITION, "", "object", "", "getCount", "getItem", "Landroidx/fragment/app/Fragment;", "getPageTitle", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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