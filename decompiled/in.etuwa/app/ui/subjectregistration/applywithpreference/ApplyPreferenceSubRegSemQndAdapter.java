package in.etuwa.app.ui.subjectregistration.applywithpreference;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplyPreferenceSubRegSemQndAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J(\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegSemQndAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegSemQndAdapter$CallBack;", "positions", "", "Ljava/lang/Integer;", "subjects", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "addItems", "", "list", CommonCssConstants.POSITION, "getItemCount", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegDialog;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApplyPreferenceSubRegSemQndAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private Integer positions;
    private final ArrayList<String> subjects = new ArrayList<>();

    /* compiled from: ApplyPreferenceSubRegSemQndAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegSemQndAdapter$CallBack;", "", "btnClicked2", "", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void btnClicked2(int position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(inflate);
        }
        if (viewType == 1) {
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sub_reg_header, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …eg_header, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.subjects.size() > 0) {
            return this.subjects.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.subjects.isEmpty() ? 1 : 0;
    }

    /* compiled from: ApplyPreferenceSubRegSemQndAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegSemQndAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegSemQndAdapter;Landroid/view/View;)V", "subject", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView subject;
        final /* synthetic */ ApplyPreferenceSubRegSemQndAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ApplyPreferenceSubRegSemQndAdapter applyPreferenceSubRegSemQndAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = applyPreferenceSubRegSemQndAdapter;
            this.subject = (TextView) itemView.findViewById(R.id.question_tv);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x005f A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #0 {Exception -> 0x0069, blocks: (B:3:0x0003, B:6:0x004f, B:7:0x005b, B:9:0x005f, B:14:0x003c, B:16:0x0042), top: B:2:0x0003 }] */
        @Override // in.etuwa.app.ui.base.BaseViewHolder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onBind(final int r4) {
            /*
                r3 = this;
                super.onBind(r4)
                in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter r0 = r3.this$0     // Catch: java.lang.Exception -> L69
                java.util.ArrayList r0 = in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter.access$getSubjects$p(r0)     // Catch: java.lang.Exception -> L69
                java.lang.Object r0 = r0.get(r4)     // Catch: java.lang.Exception -> L69
                java.lang.String r1 = "subjects[position]"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.lang.Exception -> L69
                java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L69
                android.widget.TextView r1 = r3.subject     // Catch: java.lang.Exception -> L69
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L69
                r1.setText(r0)     // Catch: java.lang.Exception -> L69
                android.view.View r0 = r3.itemView     // Catch: java.lang.Exception -> L69
                android.content.Context r0 = r0.getContext()     // Catch: java.lang.Exception -> L69
                int r1 = in.etuwa.app.R.font.poppins_semibold     // Catch: java.lang.Exception -> L69
                android.graphics.Typeface r0 = androidx.core.content.res.ResourcesCompat.getFont(r0, r1)     // Catch: java.lang.Exception -> L69
                android.view.View r1 = r3.itemView     // Catch: java.lang.Exception -> L69
                android.content.Context r1 = r1.getContext()     // Catch: java.lang.Exception -> L69
                int r2 = in.etuwa.app.R.font.poppins_regular     // Catch: java.lang.Exception -> L69
                android.graphics.Typeface r1 = androidx.core.content.res.ResourcesCompat.getFont(r1, r2)     // Catch: java.lang.Exception -> L69
                in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter r2 = r3.this$0     // Catch: java.lang.Exception -> L69
                java.lang.Integer r2 = in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter.access$getPositions$p(r2)     // Catch: java.lang.Exception -> L69
                if (r2 != 0) goto L3c
                goto L4f
            L3c:
                int r2 = r2.intValue()     // Catch: java.lang.Exception -> L69
                if (r2 != r4) goto L4f
                android.widget.TextView r1 = r3.subject     // Catch: java.lang.Exception -> L69
                int r2 = in.etuwa.app.R.drawable.shape_sharp_corner_fill_blue     // Catch: java.lang.Exception -> L69
                r1.setBackgroundResource(r2)     // Catch: java.lang.Exception -> L69
                android.widget.TextView r1 = r3.subject     // Catch: java.lang.Exception -> L69
                r1.setTypeface(r0)     // Catch: java.lang.Exception -> L69
                goto L5b
            L4f:
                android.widget.TextView r0 = r3.subject     // Catch: java.lang.Exception -> L69
                int r2 = in.etuwa.app.R.drawable.shape_sharp_unselected     // Catch: java.lang.Exception -> L69
                r0.setBackgroundResource(r2)     // Catch: java.lang.Exception -> L69
                android.widget.TextView r0 = r3.subject     // Catch: java.lang.Exception -> L69
                r0.setTypeface(r1)     // Catch: java.lang.Exception -> L69
            L5b:
                android.widget.TextView r0 = r3.subject     // Catch: java.lang.Exception -> L69
                if (r0 == 0) goto L69
                in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter r1 = r3.this$0     // Catch: java.lang.Exception -> L69
                in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter$ViewHolder$$ExternalSyntheticLambda0 r2 = new in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter$ViewHolder$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> L69
                r2.<init>()     // Catch: java.lang.Exception -> L69
                r0.setOnClickListener(r2)     // Catch: java.lang.Exception -> L69
            L69:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegSemQndAdapter.ViewHolder.onBind(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ApplyPreferenceSubRegSemQndAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.btnClicked2(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<String> list, int position) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.subjects.clear();
        this.subjects.addAll(list);
        this.positions = Integer.valueOf(position);
        notifyDataSetChanged();
    }

    public final void setCallBack(ApplyPreferenceSubRegDialog context) {
        this.listener = context;
    }
}