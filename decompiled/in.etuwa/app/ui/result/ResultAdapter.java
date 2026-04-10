package in.etuwa.app.ui.result;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.ui.result.assignment.AssignmentResultFragment;
import in.etuwa.app.ui.result.internal.InternalResultFragment;
import in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment;
import in.etuwa.app.ui.result.session.SessionalFragment;
import in.etuwa.app.ui.result.tutorials.TutorialResultFragment;
import in.etuwa.app.ui.result.university.UniversityFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultAdapter.kt */
/* loaded from: classes5.dex */
public final class ResultAdapter extends FragmentStatePagerAdapter {
    private final String[] heading;

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultAdapter(FragmentManager fm) {
        super(fm, 1);
        Intrinsics.checkNotNullParameter(fm, "fm");
        this.heading = new String[]{"Assignment", "Series Exams", "Module Test", "Tutorial", "Internal", "University"};
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    public Fragment getItem(int position) {
        Fragment fragment = new Fragment();
        if (position == 0) {
            return AssignmentResultFragment.INSTANCE.newInstance();
        }
        if (position == 1) {
            return SessionalFragment.INSTANCE.newInstance();
        }
        if (position == 2) {
            return ResultModuleTestFragment.INSTANCE.newInstance();
        }
        if (position == 3) {
            return TutorialResultFragment.INSTANCE.newInstance();
        }
        if (position != 4) {
            return position != 5 ? fragment : UniversityFragment.INSTANCE.newInstance();
        }
        return InternalResultFragment.INSTANCE.newInstance();
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