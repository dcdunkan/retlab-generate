package in.etuwa.app.ui.academicfee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.ui.chat.reply.CommentReplyDialogKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AcademicFeeFragment.kt */
/* loaded from: classes4.dex */
public final class AcademicFeeFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String id;
    private ArrayList<AcadamicFeeFirstBean> list = new ArrayList<>();

    private final void checkLastPayment(String id) {
    }

    @JvmStatic
    public static final AcademicFeeFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    private final void showDialog(String id) {
    }

    public final ArrayList<AcadamicFeeFirstBean> getList() {
        return this.list;
    }

    public final void setList(ArrayList<AcadamicFeeFirstBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.list = arrayList;
    }

    /* compiled from: AcademicFeeFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/academicfee/AcademicFeeFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/academicfee/AcademicFeeFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AcademicFeeFragment newInstance(String id) {
            AcademicFeeFragment academicFeeFragment = new AcademicFeeFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            academicFeeFragment.setArguments(bundle);
            return academicFeeFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString(CommentReplyDialogKt.ARG_IMG);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_academic_fee, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.fee));
        }
        String str = this.id;
        if (str != null) {
            if (str == null) {
                str = "";
            }
            checkLastPayment(str);
        }
    }

    private final void goNextPage(String id) {
        FragmentManager fragmentManager = getFragmentManager();
        Intrinsics.checkNotNull(fragmentManager);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "manager!!.beginTransaction()");
        beginTransaction.addToBackStack(null);
        beginTransaction.replace(R.id.main_container, AcadamicFeeListFragment.INSTANCE.newInstance(id)).commit();
    }
}