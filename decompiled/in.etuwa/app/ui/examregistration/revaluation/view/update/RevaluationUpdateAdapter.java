package in.etuwa.app.ui.examregistration.revaluation.view.update;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.examregister.RevaluationUpdate;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.examregistration.revaluation.view.update.RevaluationUpdateAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: RevaluationUpdateAdapter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0019\u001a\u00020\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001bJ\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001bH\u0016J\u0010\u0010%\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010&R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\n¨\u0006)"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/view/update/RevaluationUpdateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "answerSheetPosition", "", "", "getAnswerSheetPosition", "()Ljava/util/List;", "setAnswerSheetPosition", "(Ljava/util/List;)V", "context", "Landroid/content/Context;", "list", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/examregister/RevaluationUpdate;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/examregistration/revaluation/view/update/RevaluationUpdateAdapter$CallBack;", "revaluationPosition", "getRevaluationPosition", "setRevaluationPosition", "addItems", "", "_list", "_context", "getItemCount", "", "getItemViewType", CommonCssConstants.POSITION, "notifyDataChanged", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "Lin/etuwa/app/ui/examregistration/revaluation/view/update/RevaluationUpdateFragment;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RevaluationUpdateAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private CallBack listener;
    private final ArrayList<RevaluationUpdate> list = new ArrayList<>();
    private List<String> revaluationPosition = new ArrayList();
    private List<String> answerSheetPosition = new ArrayList();

    /* compiled from: RevaluationUpdateAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/view/update/RevaluationUpdateAdapter$CallBack;", "", "updateSelected", "", "revaluationSel", "", "", "answerSheetSel", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void updateSelected(List<String> revaluationSel, List<String> answerSheetSel);
    }

    public final List<String> getRevaluationPosition() {
        return this.revaluationPosition;
    }

    public final void setRevaluationPosition(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.revaluationPosition = list;
    }

    public final List<String> getAnswerSheetPosition() {
        return this.answerSheetPosition;
    }

    public final void setAnswerSheetPosition(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.answerSheetPosition = list;
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_revaluation_update, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …on_update, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.list.size() > 0) {
            return this.list.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.list.isEmpty() ? 1 : 0;
    }

    /* compiled from: RevaluationUpdateAdapter.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lin/etuwa/app/ui/examregistration/revaluation/view/update/RevaluationUpdateAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/examregistration/revaluation/view/update/RevaluationUpdateAdapter;Landroid/view/View;)V", "answerScript", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "answerScriptLt", "Landroid/widget/LinearLayout;", "answerSheetCopyCB", "Landroid/widget/CheckBox;", "answerSheetCopyCV", "Landroidx/cardview/widget/CardView;", "grade", "revaluationLt", "revaluationTv", "revatuationCB", "revatuationCV", "subjectHead", "type", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView answerScript;
        private final LinearLayout answerScriptLt;
        private final CheckBox answerSheetCopyCB;
        private final CardView answerSheetCopyCV;
        private final TextView grade;
        private final LinearLayout revaluationLt;
        private final TextView revaluationTv;
        private final CheckBox revatuationCB;
        private final CardView revatuationCV;
        private final TextView subjectHead;
        final /* synthetic */ RevaluationUpdateAdapter this$0;
        private final TextView type;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(RevaluationUpdateAdapter revaluationUpdateAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = revaluationUpdateAdapter;
            this.subjectHead = (TextView) itemView.findViewById(R.id.exam_sub_head);
            this.type = (TextView) itemView.findViewById(R.id.exam_type);
            this.grade = (TextView) itemView.findViewById(R.id.exam_grade);
            this.revatuationCB = (CheckBox) itemView.findViewById(R.id.revaluation_check_box);
            this.answerSheetCopyCB = (CheckBox) itemView.findViewById(R.id.answer_sheet_check_box);
            this.revatuationCV = (CardView) itemView.findViewById(R.id.revaluation_cv);
            this.answerSheetCopyCV = (CardView) itemView.findViewById(R.id.answer_script_cv);
            this.revaluationTv = (TextView) itemView.findViewById(R.id.exam_revaluation);
            this.revaluationLt = (LinearLayout) itemView.findViewById(R.id.revaluation_lt);
            this.answerScript = (TextView) itemView.findViewById(R.id.exam_answerscript);
            this.answerScriptLt = (LinearLayout) itemView.findViewById(R.id.answerscript_lt);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                Object obj = this.this$0.list.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "list[position]");
                RevaluationUpdate revaluationUpdate = (RevaluationUpdate) obj;
                this.subjectHead.setText(revaluationUpdate.getCourse());
                this.type.setText(revaluationUpdate.getType());
                this.grade.setText(revaluationUpdate.getGrade());
                this.this$0.getRevaluationPosition().add(position, "0");
                this.this$0.getAnswerSheetPosition().add(position, "0");
                if (Intrinsics.areEqual(revaluationUpdate.getAnswer_script(), "")) {
                    this.answerScriptLt.setVisibility(8);
                } else {
                    this.answerScriptLt.setVisibility(0);
                    this.answerScript.setText(revaluationUpdate.getAnswer_script());
                }
                if (Intrinsics.areEqual(revaluationUpdate.getRevaluation(), "")) {
                    this.revaluationLt.setVisibility(8);
                } else {
                    this.revaluationLt.setVisibility(0);
                    this.revaluationTv.setText(revaluationUpdate.getRevaluation());
                }
                if (StringsKt.contains$default((CharSequence) revaluationUpdate.getStatus(), (CharSequence) "revaluation", false, 2, (Object) null)) {
                    if (Intrinsics.areEqual(revaluationUpdate.getRevaluation(), "")) {
                        CardView cardView = this.revatuationCV;
                        if (cardView != null) {
                            cardView.setVisibility(0);
                        }
                        CardView cardView2 = this.answerSheetCopyCV;
                        if (cardView2 != null) {
                            cardView2.setVisibility(8);
                        }
                    } else {
                        CardView cardView3 = this.revatuationCV;
                        if (cardView3 != null) {
                            cardView3.setVisibility(8);
                        }
                        CardView cardView4 = this.answerSheetCopyCV;
                        if (cardView4 != null) {
                            cardView4.setVisibility(8);
                        }
                    }
                } else if (StringsKt.contains$default((CharSequence) revaluationUpdate.getStatus(), (CharSequence) "both", false, 2, (Object) null)) {
                    if (Intrinsics.areEqual(revaluationUpdate.getRevaluation(), "") && Intrinsics.areEqual(revaluationUpdate.getAnswer_script(), "")) {
                        CardView cardView5 = this.revatuationCV;
                        if (cardView5 != null) {
                            cardView5.setVisibility(0);
                        }
                        CardView cardView6 = this.answerSheetCopyCV;
                        if (cardView6 != null) {
                            cardView6.setVisibility(0);
                        }
                    } else if (Intrinsics.areEqual(revaluationUpdate.getRevaluation(), "") && !Intrinsics.areEqual(revaluationUpdate.getAnswer_script(), "")) {
                        CardView cardView7 = this.revatuationCV;
                        if (cardView7 != null) {
                            cardView7.setVisibility(0);
                        }
                        CardView cardView8 = this.answerSheetCopyCV;
                        if (cardView8 != null) {
                            cardView8.setVisibility(8);
                        }
                    } else if (Intrinsics.areEqual(revaluationUpdate.getAnswer_script(), "") && !Intrinsics.areEqual(revaluationUpdate.getRevaluation(), "")) {
                        CardView cardView9 = this.revatuationCV;
                        if (cardView9 != null) {
                            cardView9.setVisibility(8);
                        }
                        CardView cardView10 = this.answerSheetCopyCV;
                        if (cardView10 != null) {
                            cardView10.setVisibility(0);
                        }
                    } else {
                        CardView cardView11 = this.revatuationCV;
                        if (cardView11 != null) {
                            cardView11.setVisibility(8);
                        }
                        CardView cardView12 = this.answerSheetCopyCV;
                        if (cardView12 != null) {
                            cardView12.setVisibility(8);
                        }
                    }
                } else if (Intrinsics.areEqual(revaluationUpdate.getAnswer_script(), "")) {
                    CardView cardView13 = this.revatuationCV;
                    if (cardView13 != null) {
                        cardView13.setVisibility(8);
                    }
                    CardView cardView14 = this.answerSheetCopyCV;
                    if (cardView14 != null) {
                        cardView14.setVisibility(0);
                    }
                } else {
                    CardView cardView15 = this.revatuationCV;
                    if (cardView15 != null) {
                        cardView15.setVisibility(8);
                    }
                    CardView cardView16 = this.answerSheetCopyCV;
                    if (cardView16 != null) {
                        cardView16.setVisibility(8);
                    }
                }
                CheckBox checkBox = this.revatuationCB;
                if (checkBox != null) {
                    final RevaluationUpdateAdapter revaluationUpdateAdapter = this.this$0;
                    checkBox.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.update.RevaluationUpdateAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RevaluationUpdateAdapter.ViewHolder.onBind$lambda$0(RevaluationUpdateAdapter.ViewHolder.this, revaluationUpdateAdapter, position, view);
                        }
                    });
                }
                CheckBox checkBox2 = this.answerSheetCopyCB;
                if (checkBox2 != null) {
                    final RevaluationUpdateAdapter revaluationUpdateAdapter2 = this.this$0;
                    checkBox2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.revaluation.view.update.RevaluationUpdateAdapter$ViewHolder$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            RevaluationUpdateAdapter.ViewHolder.onBind$lambda$1(RevaluationUpdateAdapter.ViewHolder.this, revaluationUpdateAdapter2, position, view);
                        }
                    });
                }
                this.this$0.notifyDataChanged(position);
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(ViewHolder this$0, RevaluationUpdateAdapter this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.revatuationCB.isChecked()) {
                this$1.getRevaluationPosition().set(i, "true");
                CallBack callBack = this$1.listener;
                if (callBack != null) {
                    callBack.updateSelected(this$1.getRevaluationPosition(), this$1.getAnswerSheetPosition());
                    return;
                }
                return;
            }
            this$1.getRevaluationPosition().set(i, "false");
            CallBack callBack2 = this$1.listener;
            if (callBack2 != null) {
                callBack2.updateSelected(this$1.getRevaluationPosition(), this$1.getAnswerSheetPosition());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$1(ViewHolder this$0, RevaluationUpdateAdapter this$1, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.answerSheetCopyCB.isChecked()) {
                this$1.getAnswerSheetPosition().set(i, "true");
                CallBack callBack = this$1.listener;
                if (callBack != null) {
                    callBack.updateSelected(this$1.getRevaluationPosition(), this$1.getAnswerSheetPosition());
                    return;
                }
                return;
            }
            this$1.getAnswerSheetPosition().set(i, "false");
            CallBack callBack2 = this$1.listener;
            if (callBack2 != null) {
                callBack2.updateSelected(this$1.getRevaluationPosition(), this$1.getAnswerSheetPosition());
            }
        }
    }

    public final void setCallBack(RevaluationUpdateFragment context) {
        this.listener = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void notifyDataChanged(int position) {
        notifyItemChanged(position);
    }

    public final void addItems(ArrayList<RevaluationUpdate> _list, Context _context) {
        Intrinsics.checkNotNullParameter(_list, "_list");
        Intrinsics.checkNotNullParameter(_context, "_context");
        this.list.clear();
        this.list.addAll(_list);
        this.revaluationPosition.clear();
        this.answerSheetPosition.clear();
        this.context = _context;
        notifyDataSetChanged();
    }
}