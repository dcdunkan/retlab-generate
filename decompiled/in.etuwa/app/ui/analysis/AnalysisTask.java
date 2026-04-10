package in.etuwa.app.ui.analysis;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import in.etuwa.app.data.network.ApiEndPoints;
import in.etuwa.app.data.network.CallBackResponse;
import in.etuwa.app.data.network.VolleyController;
import in.etuwa.app.data.preference.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

/* JADX INFO: compiled from: AnalysisTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnalysisTask implements KoinComponent {
    private final Context context;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    public AnalysisTask(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        final AnalysisTask analysisTask = this;
        LazyThreadSafetyMode lazyThreadSafetyModeDefaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyModeDefaultLazyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                Scope rootScope;
                KoinComponent koinComponent = analysisTask;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier2, function0);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final void getAnalysis(final CallBackResponse callBackResponse) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.ANALYSIS;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda1
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                AnalysisTask.getAnalysis$lambda$0(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda2
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                AnalysisTask.getAnalysis$lambda$1(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.analysis.AnalysisTask$getAnalysis$analysisReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.analysis.AnalysisTask.getAnalysis.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAnalysis$lambda$0(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAnalysis$lambda$1(AnalysisTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error", 0).show();
    }

    public final void getSubject(final CallBackResponse callBackResponse) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.SUBJECT_GRAPH;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda8
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                AnalysisTask.getSubject$lambda$2(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda9
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                AnalysisTask.getSubject$lambda$3(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.analysis.AnalysisTask$getSubject$subjectReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.analysis.AnalysisTask.getSubject.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSubject$lambda$2(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSubject$lambda$3(AnalysisTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error", 0).show();
    }

    public final void getAcademic(final CallBackResponse callBackResponse) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.ACADEMIC_PERCENTAGE;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda3
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                AnalysisTask.getAcademic$lambda$4(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda4
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                AnalysisTask.getAcademic$lambda$5(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.analysis.AnalysisTask$getAcademic$academicReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.analysis.AnalysisTask.getAcademic.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAcademic$lambda$4(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAcademic$lambda$5(AnalysisTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error", 0).show();
    }

    public final void getAttendance(final CallBackResponse callBackResponse) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.ATTENDANCE_ANALYSIS;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda6
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                AnalysisTask.getAttendance$lambda$6(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda7
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                AnalysisTask.getAttendance$lambda$7(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.analysis.AnalysisTask$getAttendance$attendanceReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.analysis.AnalysisTask.getAttendance.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttendance$lambda$6(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttendance$lambda$7(AnalysisTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error", 0).show();
    }

    public final void getAttendancepercent(final CallBackResponse callBackResponse) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.ATTENDANCE_PERCENTAGE;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda0
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                AnalysisTask.getAttendancepercent$lambda$8(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda5
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                AnalysisTask.getAttendancepercent$lambda$9(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.analysis.AnalysisTask$getAttendancepercent$attendancepercentReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.analysis.AnalysisTask.getAttendancepercent.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttendancepercent$lambda$8(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttendancepercent$lambda$9(AnalysisTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error", 0).show();
    }

    public final void getAttendanceSubject(final CallBackResponse callBackResponse) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.ATTENDANCE_SUBJECT;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda12
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                AnalysisTask.getAttendanceSubject$lambda$10(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda13
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                AnalysisTask.getAttendanceSubject$lambda$11(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.analysis.AnalysisTask$getAttendanceSubject$attendancesubjectReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.analysis.AnalysisTask.getAttendanceSubject.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttendanceSubject$lambda$10(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAttendanceSubject$lambda$11(AnalysisTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error", 0).show();
    }

    public final void getSgpa(final CallBackResponse callBackResponse) {
        Intrinsics.checkNotNullParameter(callBackResponse, "callBackResponse");
        final String str = getPreference().getBaseUrl() + ApiEndPoints.SGPA;
        final Response.Listener listener = new Response.Listener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda10
            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                AnalysisTask.getSgpa$lambda$12(callBackResponse, (String) obj);
            }
        };
        final Response.ErrorListener errorListener = new Response.ErrorListener() { // from class: in.etuwa.app.ui.analysis.AnalysisTask$$ExternalSyntheticLambda11
            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                AnalysisTask.getSgpa$lambda$13(this.f$0, volleyError);
            }
        };
        StringRequest stringRequest = new StringRequest(str, listener, errorListener) { // from class: in.etuwa.app.ui.analysis.AnalysisTask$getSgpa$sgpaReq$1
            @Override // com.android.volley.Request
            public Map<String, String> getHeaders() {
                HashMap map = new HashMap();
                map.put("Authorization", "Bearer " + this.this$0.getPreference().getToken());
                return map;
            }
        };
        stringRequest.setRetryPolicy(new RetryPolicy() { // from class: in.etuwa.app.ui.analysis.AnalysisTask.getSgpa.1
            @Override // com.android.volley.RetryPolicy
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override // com.android.volley.RetryPolicy
            public void retry(VolleyError error) throws VolleyError {
                Intrinsics.checkNotNullParameter(error, "error");
            }
        });
        VolleyController.INSTANCE.getInstance(this.context).addToRequestQueue(stringRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSgpa$lambda$12(CallBackResponse callBackResponse, String it) {
        Intrinsics.checkNotNullParameter(callBackResponse, "$callBackResponse");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callBackResponse.serverResponse(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getSgpa$lambda$13(AnalysisTask this$0, VolleyError volleyError) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Toast.makeText(this$0.context, "Network Error", 0).show();
    }
}