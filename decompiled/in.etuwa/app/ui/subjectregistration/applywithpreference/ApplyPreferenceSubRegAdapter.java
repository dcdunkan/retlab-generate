package in.etuwa.app.ui.subjectregistration.applywithpreference;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.subjectregistration.SemSubList;
import in.etuwa.app.data.model.subjectregistration.SubjectMainList;
import in.etuwa.app.helper.EmptyViewHolder;
import in.etuwa.app.ui.base.BaseViewHolder;
import in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter;
import in.etuwa.app.utils.CustomEditText;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ApplyPreferenceSubRegAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0003J(\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0007J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fJ\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "()V", "countss", "", "Ljava/lang/Integer;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter$CallBack;", "subjects", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/subjectregistration/SubjectMainList;", "Lkotlin/collections/ArrayList;", "addItems", "", "list", CommonCssConstants.POSITION, "getItemCount", "getItemViewType", "getItems", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setCallBack", "context", "Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegDialog;", "CallBack", "ViewHolder", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApplyPreferenceSubRegAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Integer countss;
    private CallBack listener;
    private final ArrayList<SubjectMainList> subjects = new ArrayList<>();

    /* compiled from: ApplyPreferenceSubRegAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter$CallBack;", "", "onExceedMaxMark", "", "mark", "", CommonCssConstants.POSITION, "", "maxMark", "onSelectSubjectClicked", "onSgpaMarkChanged", "onSubMarkChanged", "spinnerSelected", "id", "dropDownPos", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CallBack {
        void onExceedMaxMark(String mark, int position, int maxMark);

        void onSelectSubjectClicked(int position);

        void onSgpaMarkChanged(String mark, int position);

        void onSubMarkChanged(String mark, int position);

        void spinnerSelected(int id, int position, int dropDownPos);
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
            View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_apply_preference_sub_reg, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context)\n   …e_sub_reg, parent, false)");
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

    /* compiled from: ApplyPreferenceSubRegAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter$ViewHolder;", "Lin/etuwa/app/ui/base/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Lin/etuwa/app/ui/subjectregistration/applywithpreference/ApplyPreferenceSubRegAdapter;Landroid/view/View;)V", "spinnerSubjects", "Landroid/widget/Spinner;", "kotlin.jvm.PlatformType", "subMarkEt", "Lin/etuwa/app/utils/CustomEditText;", "subject", "Landroid/widget/TextView;", "clear", "", "onBind", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ViewHolder extends BaseViewHolder {
        private final Spinner spinnerSubjects;
        private final CustomEditText subMarkEt;
        private final TextView subject;
        final /* synthetic */ ApplyPreferenceSubRegAdapter this$0;

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        protected void clear() {
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ApplyPreferenceSubRegAdapter applyPreferenceSubRegAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = applyPreferenceSubRegAdapter;
            this.subject = (TextView) itemView.findViewById(R.id.sub_name_tv);
            this.spinnerSubjects = (Spinner) itemView.findViewById(R.id.spinner_subjects);
            this.subMarkEt = (CustomEditText) itemView.findViewById(R.id.subject_mark);
        }

        @Override // in.etuwa.app.ui.base.BaseViewHolder
        public void onBind(int position) {
            int bindingAdapterPosition = getBindingAdapterPosition();
            if (bindingAdapterPosition == -1) {
                return;
            }
            Object obj = this.this$0.subjects.get(bindingAdapterPosition);
            Intrinsics.checkNotNullExpressionValue(obj, "subjects[actualPosition]");
            SubjectMainList subjectMainList = (SubjectMainList) obj;
            ArrayList<SemSubList> subjects = subjectMainList.getSubjects();
            String replace$default = StringsKt.replace$default(subjectMainList.getName(), "_", HelpFormatter.DEFAULT_LONG_OPT_SEPARATOR, false, 4, (Object) null);
            if (replace$default.length() > 0) {
                char charAt = replace$default.charAt(0);
                if (Character.isLowerCase(charAt)) {
                    charAt = Character.toTitleCase(charAt);
                }
                String substring = replace$default.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                replace$default = charAt + substring;
            }
            this.subject.setText(replace$default);
            if (StringsKt.contains$default((CharSequence) subjectMainList.getName(), (CharSequence) "minor", false, 2, (Object) null)) {
                this.subMarkEt.setHint("(out of 100)");
            } else {
                this.subMarkEt.setHint("(out of 75)");
            }
            List mutableListOf = CollectionsKt.mutableListOf("Select Subject");
            ArrayList<SemSubList> arrayList = subjects;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((SemSubList) it.next()).getName());
            }
            ArrayAdapter arrayAdapter = new ArrayAdapter(this.itemView.getContext(), android.R.layout.simple_spinner_item, CollectionsKt.plus((Collection) mutableListOf, (Iterable) arrayList2));
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.spinnerSubjects.setAdapter((SpinnerAdapter) arrayAdapter);
            Iterator<SemSubList> it2 = subjectMainList.getSubjects().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual(it2.next().getAns(), "Applied")) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                this.spinnerSubjects.setSelection(i + 1);
            } else {
                this.spinnerSubjects.setSelection(0);
            }
            Spinner spinner = this.spinnerSubjects;
            final ApplyPreferenceSubRegAdapter applyPreferenceSubRegAdapter = this.this$0;
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$ViewHolder$onBind$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                }

                /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
                
                    r2 = r2.listener;
                 */
                @Override // android.widget.AdapterView.OnItemSelectedListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onItemSelected(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                    /*
                        r0 = this;
                        java.lang.String r2 = "parent"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                        if (r3 <= 0) goto L38
                        in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$ViewHolder r1 = in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.ViewHolder.this
                        int r1 = r1.getBindingAdapterPosition()
                        r2 = -1
                        if (r1 == r2) goto L49
                        in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter r2 = r2
                        in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$CallBack r2 = in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.access$getListener$p(r2)
                        if (r2 == 0) goto L49
                        in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter r4 = r2
                        java.util.ArrayList r4 = in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.access$getSubjects$p(r4)
                        java.lang.Object r4 = r4.get(r1)
                        in.etuwa.app.data.model.subjectregistration.SubjectMainList r4 = (in.etuwa.app.data.model.subjectregistration.SubjectMainList) r4
                        java.util.ArrayList r4 = r4.getSubjects()
                        int r3 = r3 + (-1)
                        java.lang.Object r4 = r4.get(r3)
                        in.etuwa.app.data.model.subjectregistration.SemSubList r4 = (in.etuwa.app.data.model.subjectregistration.SemSubList) r4
                        int r4 = r4.getId()
                        r2.spinnerSelected(r4, r1, r3)
                        goto L49
                    L38:
                        in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$ViewHolder r1 = in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.ViewHolder.this
                        int r1 = r1.getBindingAdapterPosition()
                        in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter r2 = r2
                        in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$CallBack r2 = in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter.access$getListener$p(r2)
                        if (r2 == 0) goto L49
                        r2.onSelectSubjectClicked(r1)
                    L49:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$ViewHolder$onBind$1.onItemSelected(android.widget.AdapterView, android.view.View, int, long):void");
                }
            });
            CustomEditText customEditText = this.subMarkEt;
            String mark = ((SubjectMainList) this.this$0.subjects.get(bindingAdapterPosition)).getMark();
            if (mark == null) {
                mark = "";
            }
            customEditText.setText(mark);
            CustomEditText customEditText2 = this.subMarkEt;
            final ApplyPreferenceSubRegAdapter applyPreferenceSubRegAdapter2 = this.this$0;
            customEditText2.addTextChangedListener(new TextWatcher() { // from class: in.etuwa.app.ui.subjectregistration.applywithpreference.ApplyPreferenceSubRegAdapter$ViewHolder$onBind$2
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String str;
                    ApplyPreferenceSubRegAdapter.CallBack callBack;
                    ApplyPreferenceSubRegAdapter.CallBack callBack2;
                    ApplyPreferenceSubRegAdapter.CallBack callBack3;
                    TextView textView;
                    ApplyPreferenceSubRegAdapter.CallBack callBack4;
                    CustomEditText customEditText3;
                    TextView textView2;
                    ApplyPreferenceSubRegAdapter.CallBack callBack5;
                    CustomEditText customEditText4;
                    if (s == null || (str = s.toString()) == null) {
                        str = "";
                    }
                    int bindingAdapterPosition2 = ApplyPreferenceSubRegAdapter.ViewHolder.this.getBindingAdapterPosition();
                    if (bindingAdapterPosition2 != -1) {
                        try {
                            if (Double.parseDouble(str) > 100.0d) {
                                textView2 = ApplyPreferenceSubRegAdapter.ViewHolder.this.subject;
                                if (StringsKt.contains$default((CharSequence) textView2.getText().toString(), (CharSequence) "Minor", false, 2, (Object) null)) {
                                    callBack5 = applyPreferenceSubRegAdapter2.listener;
                                    if (callBack5 != null) {
                                        callBack5.onExceedMaxMark("0", bindingAdapterPosition2, 100);
                                    }
                                    customEditText4 = ApplyPreferenceSubRegAdapter.ViewHolder.this.subMarkEt;
                                    customEditText4.setText("");
                                    return;
                                }
                            }
                            if (Double.parseDouble(str) > 75.0d) {
                                textView = ApplyPreferenceSubRegAdapter.ViewHolder.this.subject;
                                if (StringsKt.contains$default((CharSequence) textView.getText().toString(), (CharSequence) "Mdc", false, 2, (Object) null)) {
                                    callBack4 = applyPreferenceSubRegAdapter2.listener;
                                    if (callBack4 != null) {
                                        callBack4.onExceedMaxMark("0", bindingAdapterPosition2, 75);
                                    }
                                    customEditText3 = ApplyPreferenceSubRegAdapter.ViewHolder.this.subMarkEt;
                                    customEditText3.setText("");
                                    return;
                                }
                            }
                            if (Intrinsics.areEqual(str, "")) {
                                callBack3 = applyPreferenceSubRegAdapter2.listener;
                                if (callBack3 != null) {
                                    callBack3.onSubMarkChanged("", bindingAdapterPosition2);
                                    return;
                                }
                                return;
                            }
                            callBack2 = applyPreferenceSubRegAdapter2.listener;
                            if (callBack2 != null) {
                                callBack2.onSubMarkChanged(str, bindingAdapterPosition2);
                            }
                        } catch (NumberFormatException unused) {
                            callBack = applyPreferenceSubRegAdapter2.listener;
                            if (callBack != null) {
                                callBack.onSubMarkChanged("", bindingAdapterPosition2);
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                    String str;
                    ApplyPreferenceSubRegAdapter.CallBack callBack;
                    ApplyPreferenceSubRegAdapter.CallBack callBack2;
                    ApplyPreferenceSubRegAdapter.CallBack callBack3;
                    TextView textView;
                    ApplyPreferenceSubRegAdapter.CallBack callBack4;
                    CustomEditText customEditText3;
                    TextView textView2;
                    ApplyPreferenceSubRegAdapter.CallBack callBack5;
                    CustomEditText customEditText4;
                    if (s == null || (str = s.toString()) == null) {
                        str = "";
                    }
                    int bindingAdapterPosition2 = ApplyPreferenceSubRegAdapter.ViewHolder.this.getBindingAdapterPosition();
                    if (bindingAdapterPosition2 != -1) {
                        try {
                            if (Double.parseDouble(str) > 100.0d) {
                                textView2 = ApplyPreferenceSubRegAdapter.ViewHolder.this.subject;
                                if (StringsKt.contains$default((CharSequence) textView2.getText().toString(), (CharSequence) "Minor", false, 2, (Object) null)) {
                                    callBack5 = applyPreferenceSubRegAdapter2.listener;
                                    if (callBack5 != null) {
                                        callBack5.onExceedMaxMark("0", bindingAdapterPosition2, 100);
                                    }
                                    customEditText4 = ApplyPreferenceSubRegAdapter.ViewHolder.this.subMarkEt;
                                    customEditText4.setText("");
                                    return;
                                }
                            }
                            if (Double.parseDouble(str) > 75.0d) {
                                textView = ApplyPreferenceSubRegAdapter.ViewHolder.this.subject;
                                if (StringsKt.contains$default((CharSequence) textView.getText().toString(), (CharSequence) "Mdc", false, 2, (Object) null)) {
                                    callBack4 = applyPreferenceSubRegAdapter2.listener;
                                    if (callBack4 != null) {
                                        callBack4.onExceedMaxMark("0", bindingAdapterPosition2, 75);
                                    }
                                    customEditText3 = ApplyPreferenceSubRegAdapter.ViewHolder.this.subMarkEt;
                                    customEditText3.setText("");
                                    return;
                                }
                            }
                            if (Intrinsics.areEqual(str, "")) {
                                callBack3 = applyPreferenceSubRegAdapter2.listener;
                                if (callBack3 != null) {
                                    callBack3.onSubMarkChanged("", bindingAdapterPosition2);
                                    return;
                                }
                                return;
                            }
                            callBack2 = applyPreferenceSubRegAdapter2.listener;
                            if (callBack2 != null) {
                                callBack2.onSubMarkChanged(str, bindingAdapterPosition2);
                            }
                        } catch (NumberFormatException unused) {
                            callBack = applyPreferenceSubRegAdapter2.listener;
                            if (callBack != null) {
                                callBack.onSubMarkChanged("", bindingAdapterPosition2);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.onBind(position);
    }

    public final void addItems(ArrayList<SubjectMainList> list, int position) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.subjects.clear();
        this.subjects.addAll(list);
        this.countss = Integer.valueOf(position);
        notifyDataSetChanged();
    }

    public final ArrayList<SubjectMainList> getItems() {
        return this.subjects;
    }

    public final void setCallBack(ApplyPreferenceSubRegDialog context) {
        this.listener = context;
    }
}