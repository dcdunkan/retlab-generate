package in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions;

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

/* compiled from: TeacherSurveyQuestionAdapter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002!\"B\u0005¢\u0006\u0002\u0010\u0003J@\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\u0006\u0010\u000b\u001a\u00020\tJ\b\u0010\u0015\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "attendedOrNot", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "i", "", "Ljava/lang/Integer;", "j", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter$SurveyCallBack;", "manQstn", "questionNo", "addItems", "", "list", "", "mandatory", "getItemCount", "getItemViewType", CommonCssConstants.POSITION, "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSurveyCallBack", "context", "Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionFragment;", "SurveyCallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TeacherSurveyQuestionAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Integer i;
    private Integer j;
    private SurveyCallBack listener;
    private final ArrayList<String> questionNo = new ArrayList<>();
    private final ArrayList<String> manQstn = new ArrayList<>();
    private ArrayList<String> attendedOrNot = new ArrayList<>();

    /* compiled from: TeacherSurveyQuestionAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/teachersurvey/teachersurveyquestions/TeacherSurveyQuestionAdapter$SurveyCallBack;", "", "doTheSurvey", "", "qNo", "", "j", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SurveyCallBack {
        void doTheSurvey(String qNo, int j);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_question_numbers, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …n_numbers, parent, false)");
            return new ViewHolder(this, inflate2);
        }
        View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.questionNo.size() > 0) {
            return this.questionNo.size();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !this.questionNo.isEmpty() ? 1 : 0;
    }

    /* compiled from: TeacherSurveyQuestionAdapter.kt */
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
                if (num != null && position == num.intValue()) {
                    this.questionNumber.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
                    TextView textView = this.questionNumber;
                    final TeacherSurveyQuestionAdapter teacherSurveyQuestionAdapter = this.this$0;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter$ViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TeacherSurveyQuestionAdapter.ViewHolder.onBind$lambda$0(TeacherSurveyQuestionAdapter.this, position, view);
                        }
                    });
                }
                Integer num2 = this.this$0.i;
                Intrinsics.checkNotNull(num2);
                if (position < num2.intValue()) {
                    if (!Intrinsics.areEqual(this.this$0.questionNo.get(position), "") || !Intrinsics.areEqual(this.this$0.manQstn.get(position), "false")) {
                        if (!Intrinsics.areEqual(this.this$0.questionNo.get(position), "") || !Intrinsics.areEqual(this.this$0.manQstn.get(position), "true")) {
                            if (Intrinsics.areEqual(this.this$0.questionNo.get(position), "") || !Intrinsics.areEqual(this.this$0.manQstn.get(position), "true")) {
                                if (!Intrinsics.areEqual(this.this$0.questionNo.get(position), "") && Intrinsics.areEqual(this.this$0.manQstn.get(position), "false")) {
                                    this.questionNumber.setBackgroundResource(R.drawable.question_completed);
                                }
                            } else {
                                this.questionNumber.setBackgroundResource(R.drawable.question_completed);
                            }
                        } else {
                            this.questionNumber.setBackgroundResource(R.drawable.question_not_attended);
                        }
                    } else {
                        this.questionNumber.setBackgroundResource(R.drawable.question_man_not_attended);
                    }
                } else {
                    Integer num3 = this.this$0.i;
                    Intrinsics.checkNotNull(num3);
                    if (position > num3.intValue()) {
                        if (!Intrinsics.areEqual(this.this$0.attendedOrNot.get(position), "NOT")) {
                            if (!Intrinsics.areEqual(this.this$0.questionNo.get(position), "") || !Intrinsics.areEqual(this.this$0.manQstn.get(position), "false")) {
                                if (!Intrinsics.areEqual(this.this$0.questionNo.get(position), "") || !Intrinsics.areEqual(this.this$0.manQstn.get(position), "true")) {
                                    if (Intrinsics.areEqual(this.this$0.questionNo.get(position), "") || !Intrinsics.areEqual(this.this$0.manQstn.get(position), "true")) {
                                        if (!Intrinsics.areEqual(this.this$0.questionNo.get(position), "") && Intrinsics.areEqual(this.this$0.manQstn.get(position), "false")) {
                                            this.questionNumber.setBackgroundResource(R.drawable.question_completed);
                                        }
                                    } else {
                                        this.questionNumber.setBackgroundResource(R.drawable.question_completed);
                                    }
                                } else {
                                    this.questionNumber.setBackgroundResource(R.drawable.question_not_attended);
                                }
                            } else {
                                this.questionNumber.setBackgroundResource(R.drawable.question_man_not_attended);
                            }
                        } else {
                            this.questionNumber.setBackgroundResource(R.drawable.question_default);
                        }
                    }
                }
                TextView textView2 = this.questionNumber;
                final TeacherSurveyQuestionAdapter teacherSurveyQuestionAdapter2 = this.this$0;
                textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.teachersurvey.teachersurveyquestions.TeacherSurveyQuestionAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TeacherSurveyQuestionAdapter.ViewHolder.onBind$lambda$0(TeacherSurveyQuestionAdapter.this, position, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(TeacherSurveyQuestionAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i = Integer.valueOf(i);
            SurveyCallBack surveyCallBack = this$0.listener;
            if (surveyCallBack != null) {
                String valueOf = String.valueOf(this$0.i);
                Integer num = this$0.j;
                Intrinsics.checkNotNull(num);
                surveyCallBack.doTheSurvey(valueOf, num.intValue());
            }
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