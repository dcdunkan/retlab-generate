package in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions;

import android.content.res.ColorStateList;
import android.graphics.Color;
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
import in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TeacherSurveyQuestionAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class TeacherSurveyQuestionAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Integer i;
    private boolean isSurveyFlag;
    private Integer j;
    private SurveyCallBack listener;
    private final ArrayList<String> questionNo = new ArrayList<>();
    private final ArrayList<String> manQstn = new ArrayList<>();
    private ArrayList<String> attendedOrNot = new ArrayList<>();

    /* JADX INFO: compiled from: TeacherSurveyQuestionAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter$SurveyCallBack;", "", "doTheSurvey", "", "qNo", "", "j", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SurveyCallBack {
        void doTheSurvey(String qNo, int j);
    }

    /* JADX INFO: renamed from: isSurveyFlag, reason: from getter */
    public final boolean getIsSurveyFlag() {
        return this.isSurveyFlag;
    }

    public final void setSurveyFlag(boolean z) {
        this.isSurveyFlag = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_question_numbers, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate, "from(parent.context)\n   …n_numbers, parent, false)");
            return new ViewHolder(this, viewInflate);
        }
        View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …mpty_view, parent, false)");
        return new EmptyViewHolder(viewInflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.questionNo.isEmpty()) {
            return this.questionNo.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.questionNo.isEmpty() ? 1 : 0;
    }

    /* JADX INFO: compiled from: TeacherSurveyQuestionAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter;Landroid/view/View;)V", "questionNumber", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView questionNumber;
        final /* synthetic */ TeacherSurveyQuestionAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(TeacherSurveyQuestionAdapter teacherSurveyQuestionAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = teacherSurveyQuestionAdapter;
            this.questionNumber = (TextView) itemView.findViewById(R.id.question_tv);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(final int position) {
            super.onBind(position);
            try {
                this.questionNumber.setText(String.valueOf(position + 1));
                Integer num = this.this$0.i;
                if (num == null || position != num.intValue()) {
                    Integer num2 = this.this$0.i;
                    Intrinsics.checkNotNull(num2);
                    if (position < num2.intValue() || !Intrinsics.areEqual(this.this$0.attendedOrNot.get(position), "NOT")) {
                        boolean z = !Intrinsics.areEqual(this.this$0.questionNo.get(position), "");
                        boolean zAreEqual = Intrinsics.areEqual(this.this$0.manQstn.get(position), "true");
                        if (z) {
                            this.questionNumber.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#43A047")));
                            this.questionNumber.setTextColor(-1);
                        } else if (zAreEqual) {
                            this.questionNumber.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#EF5350")));
                            this.questionNumber.setTextColor(-1);
                        } else {
                            this.questionNumber.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFB300")));
                            this.questionNumber.setTextColor(-1);
                        }
                    } else {
                        this.questionNumber.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#EEEEEE")));
                        this.questionNumber.setTextColor(Color.parseColor("#9E9E9E"));
                    }
                } else {
                    this.questionNumber.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#545996")));
                    this.questionNumber.setTextColor(-1);
                }
                TextView textView = this.questionNumber;
                final TeacherSurveyQuestionAdapter teacherSurveyQuestionAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TeacherSurveyQuestionAdapter.ViewHolder.onBind$lambda$1(teacherSurveyQuestionAdapter, position, this, view);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x008b A[EDGE_INSN: B:41:0x008b->B:32:0x008b BREAK  A[LOOP:0: B:11:0x002d->B:44:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[LOOP:0: B:11:0x002d->B:44:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final void onBind$lambda$1(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter r6, int r7, in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter.ViewHolder r8, android.view.View r9) {
            /*
                Method dump skipped, instruction units count: 219
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter.ViewHolder.onBind$lambda$1(in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter, int, in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter$ViewHolder, android.view.View):void");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(List<String> list, int i, List<String> mandatory, List<String> attendedOrNot, int j) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(mandatory, "mandatory");
        Intrinsics.checkNotNullParameter(attendedOrNot, "attendedOrNot");
        this.i = Integer.valueOf(i);
        this.j = Integer.valueOf(j);
        this.questionNo.clear();
        this.questionNo.addAll(list);
        this.manQstn.clear();
        this.manQstn.addAll(mandatory);
        this.attendedOrNot.clear();
        this.attendedOrNot.addAll(attendedOrNot);
        notifyDataSetChanged();
    }

    public final void setSurveyCallBack(TeacherSurveyQuestionFragment context) {
        this.listener = context;
    }
}