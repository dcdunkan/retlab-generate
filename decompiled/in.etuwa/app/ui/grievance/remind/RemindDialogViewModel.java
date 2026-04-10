package in.etuwa.app.ui.grievance.remind;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.itextpdf.kernel.xmp.PdfConst;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.repository.GrievanceRepository;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.Resource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RemindDialogViewModel.kt */
/* loaded from: classes4.dex */
public final class RemindDialogViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final GrievanceRepository grievanceRepository;
    private MutableLiveData<Resource<SuccessResponse>> remindResponse;

    public RemindDialogViewModel(GrievanceRepository grievanceRepository) {
        Intrinsics.checkNotNullParameter(grievanceRepository, "grievanceRepository");
        this.grievanceRepository = grievanceRepository;
        this.compositeDisposable = new CompositeDisposable();
        this.remindResponse = new MutableLiveData<>();
    }

    public final void remindGrievance(String id, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.remindResponse.postValue(Resource.INSTANCE.loading(null));
        CompositeDisposable compositeDisposable = this.compositeDisposable;
        Single<SuccessResponse> observeOn = this.grievanceRepository.remindGrievanceApiCall(id, description).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<SuccessResponse, Unit> function1 = new Function1<SuccessResponse, Unit>() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialogViewModel$remindGrievance$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuccessResponse successResponse) {
                invoke2(successResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuccessResponse successResponse) {
                MutableLiveData mutableLiveData;
                mutableLiveData = RemindDialogViewModel.this.remindResponse;
                mutableLiveData.postValue(Resource.INSTANCE.success(successResponse));
            }
        };
        Consumer<? super SuccessResponse> consumer = new Consumer() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialogViewModel$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RemindDialogViewModel.remindGrievance$lambda$0(Function1.this, obj);
            }
        };
        final Function1<Throwable, Unit> function12 = new Function1<Throwable, Unit>() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialogViewModel$remindGrievance$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                MutableLiveData mutableLiveData;
                mutableLiveData = RemindDialogViewModel.this.remindResponse;
                mutableLiveData.postValue(Resource.INSTANCE.exception(AppConstant.ERROR_MSG));
            }
        };
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: in.etuwa.app.ui.grievance.remind.RemindDialogViewModel$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RemindDialogViewModel.remindGrievance$lambda$1(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void remindGrievance$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void remindGrievance$lambda$1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final MutableLiveData<Resource<SuccessResponse>> getResponse() {
        return this.remindResponse;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        this.compositeDisposable.dispose();
    }
}