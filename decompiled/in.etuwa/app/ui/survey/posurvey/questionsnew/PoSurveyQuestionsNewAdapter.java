package in.etuwa.app.ui.survey.posurvey.questionsnew;

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
import in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PoSurveyQuestionsNewAdapter.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PoSurveyQuestionsNewAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Integer i;
    private Integer j;
    private SurveyCallBack listener;
    private final ArrayList<String> questionNo = new ArrayList<>();
    private final ArrayList<String> manQstn = new ArrayList<>();
    private ArrayList<String> attendedOrNot = new ArrayList<>();

    /* JADX INFO: compiled from: PoSurveyQuestionsNewAdapter.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewAdapter$SurveyCallBack;", "", "doTheSurvey", "", "qNo", "", "j", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SurveyCallBack {
        void doTheSurvey(String qNo, int j);
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
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_question_numbers, parent, false);
            Intrinsics.checkNotNullExpressionValue(viewInflate2, "from(parent.context)\n   …n_numbers, parent, false)");
            return new ViewHolder(this, viewInflate2);
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate3, "from(parent.context).inf…  false\n                )");
        return new EmptyViewHolder(viewInflate3);
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

    /* JADX INFO: compiled from: PoSurveyQuestionsNewAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/survey/posurvey/questionsnew/PoSurveyQuestionsNewAdapter;Landroid/view/View;)V", "questionNumber", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final TextView questionNumber;
        final /* synthetic */ PoSurveyQuestionsNewAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(PoSurveyQuestionsNewAdapter poSurveyQuestionsNewAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = poSurveyQuestionsNewAdapter;
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
                } else {
                    this.questionNumber.setBackgroundResource(R.drawable.shape_sharp_corner_fill_dark);
                }
                TextView textView = this.questionNumber;
                final PoSurveyQuestionsNewAdapter poSurveyQuestionsNewAdapter = this.this$0;
                textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.posurvey.questionsnew.PoSurveyQuestionsNewAdapter$ViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PoSurveyQuestionsNewAdapter.ViewHolder.onBind$lambda$0(poSurveyQuestionsNewAdapter, position, view);
                    }
                });
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBind$lambda$0(PoSurveyQuestionsNewAdapter this$0, int i, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i = Integer.valueOf(i);
            SurveyCallBack surveyCallBack = this$0.listener;
            if (surveyCallBack != null) {
                String strValueOf = String.valueOf(this$0.i);
                Integer num = this$0.j;
                Intrinsics.checkNotNull(num);
                surveyCallBack.doTheSurvey(strValueOf, num.intValue());
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

    public final void setSurveyCallBack(PoSurveyQuestionsNewFragment context) {
        this.listener = context;
    }
}