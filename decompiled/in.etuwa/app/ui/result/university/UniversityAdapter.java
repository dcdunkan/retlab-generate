package in.etuwa.app.ui.result.university;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.data.model.result.univ.UnivDetails;
import in.etuwa.app.data.model.result.univ.UnivExamSubjects;
import in.etuwa.app.data.model.result.univ.UnivExams;
import in.etuwa.app.data.model.result.univ.UnivSubjects;
import in.etuwa.app.ui.result.university.exampages.UniversityExamsFragment;
import in.etuwa.app.ui.result.university.initialpage.UnivInitialPageFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;

/* compiled from: UniversityAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lin/etuwa/app/ui/result/university/UniversityAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "(Landroidx/fragment/app/FragmentManager;)V", ErrorBundle.DETAIL_ENTRY, "Lin/etuwa/app/data/model/result/univ/UnivDetails;", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/result/univ/UnivSubjects;", "Lkotlin/collections/ArrayList;", "univExams", "Lin/etuwa/app/data/model/result/univ/UnivExams;", "addItems", "", "_details", "_subjects", "_univExams", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", CommonCssConstants.POSITION, "getPageTitle", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniversityAdapter extends FragmentStatePagerAdapter {
    private UnivDetails details;
    private ArrayList<UnivSubjects> subjects;
    private ArrayList<UnivExams> univExams;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UniversityAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.subjects = new ArrayList<>();
        this.univExams = new ArrayList<>();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        if (position == 0) {
            return UnivInitialPageFragment.INSTANCE.newInstance(this.details, this.subjects);
        }
        ArrayList<UnivExamSubjects> subjects = this.univExams.get(position).getSubjects();
        if (subjects == null) {
            subjects = new ArrayList<>();
        }
        return UniversityExamsFragment.INSTANCE.newInstance(subjects);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.univExams.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.univExams.get(position).getExamName();
    }

    public final void addItems(UnivDetails _details, ArrayList<UnivSubjects> _subjects, ArrayList<UnivExams> _univExams) {
        Intrinsics.checkNotNullParameter(_details, "_details");
        Intrinsics.checkNotNullParameter(_subjects, "_subjects");
        Intrinsics.checkNotNullParameter(_univExams, "_univExams");
        this.details = null;
        this.subjects.clear();
        this.univExams.clear();
        this.details = _details;
        this.subjects.addAll(_subjects);
        this.univExams.add(new UnivExams("Status", new ArrayList()));
        this.univExams.addAll(_univExams);
        notifyDataSetChanged();
    }
}