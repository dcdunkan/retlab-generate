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