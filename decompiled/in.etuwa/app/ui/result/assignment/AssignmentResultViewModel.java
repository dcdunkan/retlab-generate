package in.etuwa.app.ui.result.assignment;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.attendance.AttendanceRequest;
import in.etuwa.app.data.model.result.ResultAssignment;
import in.etuwa.app.data.repository.ResultRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssignmentResultViewModel.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class AssignmentResultViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final ResultRepository resultRepository;
    private MutableLiveData<Resource<ArrayList<ResultAssignment>>> resultResponse;
    private MutableLiveData<Resource<ArrayList<Semester>>> semResponse;

    public AssignmentResultViewModel(ResultRepository resultRepository) {
        Intrinsics.checkNotNullParameter(resultRepository, "resultRepository");
        this.resultRepository = resultRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.resultResponse = new MutableLiveData<>();
        this.semResponse = new MutableLiveData<>();
    }

    public final void getSemester(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences("app_prefs", 0).getString("semester_list", null);
        if (string != null) {
            Object objFromJson = new Gson().fromJson(string, new TypeToken<ArrayList<Semester>>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultViewModel$getSemester$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "Gson().fromJson(json, type)");
            this.semResponse.postValue(Resource.INSTANCE.success((ArrayList) objFromJson));
            return;
        }
        this.semResponse.postValue(Resource.INSTANCE.error("No cached semester data", null));
    }

    public final MutableLiveData<Resource<ArrayList<Semester>>> getSemResponse() {
        return this.semResponse;
    }

    public final void getResult(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.resultResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<ArrayList<ResultAssignment>> singleObserveOn = this.resultRepository.getResultAssignmentApiCall(new AttendanceRequest(id)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<ArrayList<ResultAssignment>, Unit> function1 = new Function1<ArrayList<ResultAssignment>, Unit>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultViewModel.getResult.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<ResultAssignment> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<ResultAssignment> arrayList) {
                AssignmentResultViewModel.this.resultResponse.postValue(Resource.INSTANCE.success(arrayList));
            }
        };
        Consumer<? super ArrayList<ResultAssignment>> consumer = new Consumer() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AssignmentResultViewModel.getResult$lambda$0(function1, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultViewModel.getResult.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                AssignmentResultViewModel.this.resultResponse.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(singleObserveOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.result.assignment.AssignmentResultViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AssignmentResultViewModel.getResult$lambda$1(function12, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getResult$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getResult$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<ArrayList<ResultAssignment>>> getResponse() {
        return this.resultResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}