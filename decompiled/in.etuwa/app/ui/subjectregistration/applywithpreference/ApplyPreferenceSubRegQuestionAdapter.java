package in.etuwa.app.ui.subjectregistration.applywithpreference;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegQuestionAdapter;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApplyPreferenceSubRegQuestionAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ApplyPreferenceSubRegQuestionAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private CallBack listener;
    private Integer positions;
    private final ArrayList<String> subjects = new ArrayList<>();

    /* JADX INFO: compiled from: ApplyPreferenceSubRegQuestionAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegQuestionAdapter$CallBack;", "", "btnClicked", "", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void btnClicked(int position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context).inf…mpty_view, parent, false)");
            return new EmptyViewHolder(viewInflate);
        }
        if (viewType == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_sub_reg_header, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …eg_header, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: ApplyPreferenceSubRegQuestionAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegQuestionAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegQuestionAdapter;Landroid/view/View;)V", "subject", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView subject;
        final /* synthetic */ ApplyPreferenceSubRegQuestionAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ApplyPreferenceSubRegQuestionAdapter applyPreferenceSubRegQuestionAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = applyPreferenceSubRegQuestionAdapter;
            this.subject = (TextView) itemView.findViewById(R.id.question_tv);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.subjects.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "subjects[position]");
                this.subject.setText((String) obj);
                Typeface font = ResourcesCompat.getFont(this.itemView.getContext(), R.font.poppins_semibold);
                Typeface font2 = ResourcesCompat.getFont(this.itemView.getContext(), R.font.poppins_regular);
                Integer num = this.this$0.positions;
                if (num != null && num.intValue() == position) {
                    this.subject.setBackgroundResource(R.drawable.shape_sharp_corner_fill_blue);
                    this.subject.setTypeface(font);
                } else {
                    this.subject.setBackgroundResource(R.drawable.shape_sharp_unselected);
                    this.subject.setTypeface(font2);
                }
                TextView textView = this.subject;
                if (textView != null) {
                    final ApplyPreferenceSubRegQuestionAdapter applyPreferenceSubRegQuestionAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegQuestionAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ApplyPreferenceSubRegQuestionAdapter.ViewHolder.onBind$lambda$0(applyPreferenceSubRegQuestionAdapter, position, view);
                        }
                    });
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ApplyPreferenceSubRegQuestionAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            CallBack callBack = this$0.listener;
            if (callBack != null) {
                callBack.btnClicked(i);
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