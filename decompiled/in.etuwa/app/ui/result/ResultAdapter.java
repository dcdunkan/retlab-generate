package in.etuwa.app.ui.result;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.assignment.AssignmentResultFragment;
import in.etuwa.app.ui.result.internal.InternalResultFragment;
import in.etuwa.app.ui.result.moduletest.ResultModuleTestFragment;
import in.etuwa.app.ui.result.session.SessionalFragment;
import in.etuwa.app.ui.result.tutorials.TutorialResultFragment;
import in.etuwa.app.ui.result.university.UniversityFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ResultAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ResultAdapter extends FragmentStateAdapter {
    private final List<BaseFragment> fragments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResultAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        this.fragments = CollectionsKt.listOf((Object[]) new BaseFragment[]{AssignmentResultFragment.INSTANCE.newInstance(), SessionalFragment.INSTANCE.newInstance(), ResultModuleTestFragment.INSTANCE.newInstance(), TutorialResultFragment.INSTANCE.newInstance(), InternalResultFragment.INSTANCE.newInstance(), UniversityFragment.INSTANCE.newInstance()});
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.fragments.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        return this.fragments.get(position);
    }
}