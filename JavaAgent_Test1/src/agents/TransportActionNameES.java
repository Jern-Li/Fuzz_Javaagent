package agents;

public class TransportActionNameES {

    public final String[] TransportActionName;
    public final int cover_num;

    public TransportActionNameES()
    {
        cover_num = 0;
        TransportActionName = new String[]{
                "org.elasticsearch.plugin.noop.action.bulk.TransportNoopBulkAction",
                "org.elasticsearch.plugin.noop.action.search.TransportNoopSearchAction",
//                "org.elasticsearch.ingest.common.GrokProcessorGetAction",  //subclass
                "org.elasticsearch.script.mustache.TransportMultiSearchTemplateAction",
                "org.elasticsearch.script.mustache.TransportSearchTemplateAction",
//                "org.elasticsearch.painless.action.PainlessContextAction", //subclass
//                "org.elasticsearch.painless.action.PainlessExecuteAction", //subclass
                "org.elasticsearch.index.rankeval.TransportRankEvalAction",
                "org.elasticsearch.index.reindex.TransportRethrottleAction",
                "org.elasticsearch.action.admin.cluster.allocation.TransportClusterAllocationExplainAction",
                "org.elasticsearch.action.admin.cluster.configuration.TransportAddVotingConfigExclusionsAction",
                "org.elasticsearch.action.admin.cluster.configuration.TransportClearVotingConfigExclusionsAction",
                "org.elasticsearch.action.admin.cluster.health.TransportClusterHealthAction",
                "org.elasticsearch.action.admin.cluster.node.hotthreads.TransportNodesHotThreadsAction",
                "org.elasticsearch.action.admin.cluster.node.info.TransportNodesInfoAction",
                "org.elasticsearch.action.admin.cluster.node.reload.TransportNodesReloadSecureSettingsAction",
                "org.elasticsearch.action.admin.cluster.node.stats.TransportNodesStatsAction",
                "org.elasticsearch.action.admin.cluster.node.tasks.cancel.TransportCancelTasksAction",
                "org.elasticsearch.action.admin.cluster.node.tasks.get.TransportGetTaskAction",
                "org.elasticsearch.action.admin.cluster.node.tasks.list.TransportListTasksAction",
                "org.elasticsearch.action.admin.cluster.node.usage.TransportNodesUsageAction",
                "org.elasticsearch.action.admin.cluster.remote.TransportRemoteInfoAction",
                "org.elasticsearch.action.admin.cluster.repositories.cleanup.TransportCleanupRepositoryAction",
                "org.elasticsearch.action.admin.cluster.repositories.delete.TransportDeleteRepositoryAction",
                "org.elasticsearch.action.admin.cluster.repositories.get.TransportGetRepositoriesAction",
                "org.elasticsearch.action.admin.cluster.repositories.put.TransportPutRepositoryAction",
                "org.elasticsearch.action.admin.cluster.repositories.verify.TransportVerifyRepositoryAction",
                "org.elasticsearch.action.admin.cluster.reroute.TransportClusterRerouteAction",
                "org.elasticsearch.action.admin.cluster.settings.TransportClusterUpdateSettingsAction",
                "org.elasticsearch.action.admin.cluster.shards.TransportClusterSearchShardsAction",
                "org.elasticsearch.action.admin.cluster.snapshots.create.TransportCreateSnapshotAction",
                "org.elasticsearch.action.admin.cluster.snapshots.delete.TransportDeleteSnapshotAction",
                "org.elasticsearch.action.admin.cluster.snapshots.get.TransportGetSnapshotsAction",
                "org.elasticsearch.action.admin.cluster.snapshots.restore.TransportRestoreSnapshotAction",
                "org.elasticsearch.action.admin.cluster.snapshots.status.TransportSnapshotsStatusAction",
                "org.elasticsearch.action.admin.cluster.state.TransportClusterStateAction",
                "org.elasticsearch.action.admin.cluster.stats.TransportClusterStatsAction",
                "org.elasticsearch.action.admin.cluster.storedscripts.TransportDeleteStoredScriptAction",
                "org.elasticsearch.action.admin.cluster.storedscripts.TransportGetStoredScriptAction",
                "org.elasticsearch.action.admin.cluster.storedscripts.TransportPutStoredScriptAction",
                "org.elasticsearch.action.admin.cluster.tasks.TransportPendingClusterTasksAction",
                "org.elasticsearch.action.admin.indices.alias.TransportIndicesAliasesAction",
                "org.elasticsearch.action.admin.indices.alias.exists.TransportAliasesExistAction",
                "org.elasticsearch.action.admin.indices.alias.get.TransportGetAliasesAction",

                //special, mapper
                "org.elasticsearch.action.admin.indices.analyze.TransportAnalyzeAction",
                "org.elasticsearch.xpack.security.action.SecurityMapper",

                "org.elasticsearch.action.admin.indices.cache.clear.TransportClearIndicesCacheAction",
                "org.elasticsearch.action.admin.indices.close.TransportCloseIndexAction",
                "org.elasticsearch.action.admin.indices.create.TransportCreateIndexAction",
                "org.elasticsearch.action.admin.indices.delete.TransportDeleteIndexAction",
                "org.elasticsearch.action.admin.indices.exists.indices.TransportIndicesExistsAction",
                "org.elasticsearch.action.admin.indices.exists.types.TransportTypesExistsAction",
                "org.elasticsearch.action.admin.indices.flush.TransportFlushAction",
                "org.elasticsearch.action.admin.indices.flush.TransportSyncedFlushAction",
                "org.elasticsearch.action.admin.indices.forcemerge.TransportForceMergeAction",
                "org.elasticsearch.action.admin.indices.get.TransportGetIndexAction",
                "org.elasticsearch.action.admin.indices.mapping.get.TransportGetFieldMappingsAction",
                "org.elasticsearch.action.admin.indices.mapping.get.TransportGetMappingsAction",
                "org.elasticsearch.action.admin.indices.mapping.put.TransportPutMappingAction",
                "org.elasticsearch.action.admin.indices.open.TransportOpenIndexAction",
                "org.elasticsearch.action.admin.indices.recovery.TransportRecoveryAction",
                "org.elasticsearch.action.admin.indices.refresh.TransportRefreshAction",
                "org.elasticsearch.action.admin.indices.rollover.TransportRolloverAction",
                "org.elasticsearch.action.admin.indices.segments.TransportIndicesSegmentsAction",
                "org.elasticsearch.action.admin.indices.settings.get.TransportGetSettingsAction",
                "org.elasticsearch.action.admin.indices.settings.put.TransportUpdateSettingsAction",
                "org.elasticsearch.action.admin.indices.shards.TransportIndicesShardStoresAction",
                "org.elasticsearch.action.admin.indices.shrink.TransportResizeAction",

                //special, already in TransportResizeAction
//                "org.elasticsearch.action.admin.indices.shrink.ShrinkAction",

                //special, CCRlicense
                "org.elasticsearch.action.admin.indices.stats.TransportIndicesStatsAction",
                "org.elasticsearch.xpack.ccr.CcrLicenseChecker",

                "org.elasticsearch.action.admin.indices.template.delete.TransportDeleteIndexTemplateAction",
                "org.elasticsearch.action.admin.indices.template.get.TransportGetIndexTemplatesAction",
                "org.elasticsearch.action.admin.indices.template.put.TransportPutIndexTemplateAction",
                "org.elasticsearch.action.admin.indices.upgrade.get.TransportUpgradeStatusAction",
                "org.elasticsearch.action.admin.indices.upgrade.post.TransportUpgradeAction",
                "org.elasticsearch.action.admin.indices.upgrade.post.TransportUpgradeSettingsAction",
                "org.elasticsearch.action.admin.indices.validate.query.TransportValidateQueryAction",
                "org.elasticsearch.action.bulk.TransportBulkAction",
                "org.elasticsearch.action.delete.TransportDeleteAction",
                "org.elasticsearch.action.explain.TransportExplainAction",
                "org.elasticsearch.action.fieldcaps.TransportFieldCapabilitiesAction",
                "org.elasticsearch.action.get.TransportGetAction",
                "org.elasticsearch.action.get.TransportMultiGetAction",
                "org.elasticsearch.action.index.TransportIndexAction",

                //special, "Transport" in different place
                "org.elasticsearch.action.ingest.DeletePipelineTransportAction",
                "org.elasticsearch.action.ingest.GetPipelineTransportAction",
                "org.elasticsearch.action.ingest.PutPipelineTransportAction",
                "org.elasticsearch.action.ingest.SimulatePipelineTransportAction",

                "org.elasticsearch.action.main.TransportMainAction",

                //special, engine, mapper
                "org.elasticsearch.action.search.TransportClearScrollAction",
                "org.elasticsearch.xpack.security.authz.RBACEngine",

                //special, service, engine
                "org.elasticsearch.action.search.TransportMultiSearchAction",
                "org.elasticsearch.action.search.SearchTransportService",

                //special, in different one
//                "org.elasticsearch.action.search.SearchAction",
                "org.elasticsearch.xpack.ml.action.TransportPutDatafeedAction",

                //special, engine
                "org.elasticsearch.action.search.TransportSearchScrollAction",
                "org.elasticsearch.action.termvectors.TransportMultiTermVectorsAction",

                "org.elasticsearch.action.termvectors.TransportTermVectorsAction",
                "org.elasticsearch.action.update.TransportUpdateAction",

                //special
//                "org.elasticsearch.index.reindex.DeleteByQueryAction",
//                "org.elasticsearch.index.reindex.ReindexAction",
//                "org.elasticsearch.index.reindex.UpdateByQueryAction",
                "org.elasticsearch.index.reindex.RethrottleRequest",


//                "org.elasticsearch.persistent.CompletionPersistentTaskAction",//subclass
//                "org.elasticsearch.persistent.RemovePersistentTaskAction",//subclass
//                "org.elasticsearch.persistent.StartPersistentTaskAction",//subclass
//                "org.elasticsearch.persistent.UpdatePersistentTaskStatusAction",//subclass
//                "org.elasticsearch.xpack.ccr.action.ShardChangesAction",//subclass
//                "org.elasticsearch.xpack.ccr.action.bulk.TransportBulkShardOperationsAction",
//                "org.elasticsearch.xpack.ccr.action.repositories.ClearCcrRestoreSessionAction",//subclass
//                "org.elasticsearch.xpack.ccr.action.repositories.DeleteInternalCcrRepositoryAction",//subclass
//                "org.elasticsearch.xpack.ccr.action.repositories.GetCcrRestoreFileChunkAction",//subclass
//                "org.elasticsearch.xpack.ccr.action.repositories.PutCcrRestoreSessionAction",//subclass
//                "org.elasticsearch.xpack.ccr.action.repositories.PutInternalCcrRepositoryAction",//subclass

                "org.elasticsearch.license.TransportDeleteLicenseAction",
                "org.elasticsearch.license.TransportGetBasicStatusAction",
                "org.elasticsearch.license.TransportGetLicenseAction",
                "org.elasticsearch.license.TransportGetTrialStatusAction",
                "org.elasticsearch.license.TransportPostStartBasicAction",
                "org.elasticsearch.license.TransportPostStartTrialAction",
                "org.elasticsearch.license.TransportPutLicenseAction",
                "org.elasticsearch.xpack.core.action.TransportReloadAnalyzerAction",
                "org.elasticsearch.xpack.core.action.TransportXPackInfoAction",
                "org.elasticsearch.xpack.core.action.TransportXPackUsageAction",
                "org.elasticsearch.xpack.core.analytics.action.TransportAnalyticsStatsAction",
                "org.elasticsearch.xpack.core.ccr.action.TransportActivateAutoFollowPatternAction",

                //special, none unless the constructor itself
//                "org.elasticsearch.xpack.core.ccr.action.CcrStatsAction",


                "org.elasticsearch.xpack.core.ccr.action.TransportDeleteAutoFollowPatternAction",
                "org.elasticsearch.xpack.core.ccr.action.TransportFollowInfoAction",

                //special, though there's "Transport" action, but NAME is not used
//                "org.elasticsearch.xpack.core.ccr.action.FollowStatsAction",


                "org.elasticsearch.xpack.core.ccr.action.TransportForgetFollowerAction",
                "org.elasticsearch.xpack.core.ccr.action.TransportGetAutoFollowPatternAction",
                "org.elasticsearch.xpack.core.ccr.action.TransportPauseFollowAction",
                "org.elasticsearch.xpack.core.ccr.action.TransportPutAutoFollowPatternAction",
                "org.elasticsearch.xpack.core.ccr.action.TransportPutFollowAction",

                //special, outside the code itself, NAME is not used   or maybe some subclasses
//                "org.elasticsearch.xpack.core.ccr.action.ResumeFollowAction",
//                "org.elasticsearch.xpack.core.deprecation.NodesDeprecationCheckAction",
//                "org.elasticsearch.xpack.core.enrich.action.ExecuteEnrichPolicyAction",
//                "org.elasticsearch.xpack.core.ilm.action.PutLifecycleAction",
//                "org.elasticsearch.xpack.core.ilm.action.RetryAction",
//                "org.elasticsearch.xpack.core.ml.action.DeleteDataFrameAnalyticsAction",
//                "org.elasticsearch.xpack.core.ml.action.DeleteExpiredDataAction",
//                "org.elasticsearch.xpack.core.ml.action.DeleteForecastAction",
//                "org.elasticsearch.xpack.core.ml.action.DeleteJobAction",
//                "org.elasticsearch.xpack.core.ml.action.EvaluateDataFrameAction",
//                "org.elasticsearch.xpack.core.ml.action.FlushJobAction",
//                "org.elasticsearch.xpack.core.ml.action.GetBucketsAction",
//                "org.elasticsearch.xpack.core.ml.action.GetCategoriesAction",
//                "org.elasticsearch.xpack.core.ml.action.GetDataFrameAnalyticsStatsAction",
//                "org.elasticsearch.xpack.core.ml.action.GetOverallBucketsAction",
//                "org.elasticsearch.xpack.core.ml.action.MlInfoAction",
//                "org.elasticsearch.xpack.core.ml.action.PostCalendarEventsAction",
//                "org.elasticsearch.xpack.core.ml.action.PreviewDatafeedAction",
//                "org.elasticsearch.xpack.core.ml.action.PutFilterAction",
//                "org.elasticsearch.xpack.core.ml.action.UpdateFilterAction",
//                "org.elasticsearch.xpack.core.ml.action.UpdateModelSnapshotAction",
//                "org.elasticsearch.xpack.core.ml.action.ValidateJobConfigAction",
//                "org.elasticsearch.xpack.core.security.action.privilege.GetPrivilegesAction",
//                "org.elasticsearch.xpack.core.security.action.privilege.PutPrivilegesAction",
//                "org.elasticsearch.xpack.core.security.action.role.PutRoleAction",
//                "org.elasticsearch.xpack.core.security.action.rolemapping.DeleteRoleMappingAction",
//                "org.elasticsearch.xpack.core.security.action.rolemapping.GetRoleMappingsAction",
//                "org.elasticsearch.xpack.core.security.action.saml.SamlPrepareAuthenticationAction",
//                "org.elasticsearch.xpack.core.security.action.user.DeleteUserAction",
//                "org.elasticsearch.xpack.core.security.action.user.SetEnabledAction",
//                "org.elasticsearch.xpack.core.upgrade.actions.IndexUpgradeAction",
//                "org.elasticsearch.xpack.core.upgrade.actions.IndexUpgradeInfoAction",
//                "org.elasticsearch.xpack.core.watcher.transport.actions.activate.ActivateWatchAction",
//                "org.elasticsearch.xpack.core.watcher.transport.actions.delete.DeleteWatchAction",
//                "org.elasticsearch.xpack.core.watcher.transport.actions.get.GetWatchAction",
//                "org.elasticsearch.xpack.enrich.action.EnrichCoordinatorStatsAction",
//                "org.elasticsearch.xpack.enrich.action.EnrichShardMultiSearchAction",
//                "org.elasticsearch.xpack.sql.action.SqlQueryAction",

                "org.elasticsearch.xpack.core.ccr.action.TransportUnfollowAction",
                "org.elasticsearch.xpack.core.deprecation.TransportDeprecationInfoAction",
                "org.elasticsearch.xpack.core.enrich.action.TransportDeleteEnrichPolicyAction",
                "org.elasticsearch.xpack.core.enrich.action.TransportEnrichStatsAction",
                "org.elasticsearch.xpack.core.enrich.action.TransportGetEnrichPolicyAction",
                "org.elasticsearch.xpack.core.enrich.action.TransportPutEnrichPolicyAction",
                "org.elasticsearch.xpack.core.frozen.action.TransportFreezeIndexAction",
                "org.elasticsearch.xpack.core.graph.action.TransportGraphExploreAction",
                "org.elasticsearch.xpack.core.ilm.action.TransportDeleteLifecycleAction",

                //special, indexprivilege
//                "org.elasticsearch.xpack.core.ilm.action.ExplainLifecycleAction",
                "org.elasticsearch.xpack.core.security.authz.privilege.IndexPrivilege",

                "org.elasticsearch.xpack.core.ilm.action.TransportGetLifecycleAction",
                "org.elasticsearch.xpack.core.ilm.action.TransportGetStatusAction",
                "org.elasticsearch.xpack.core.ilm.action.TransportMoveToStepAction",
                "org.elasticsearch.xpack.core.ilm.action.TransportRemoveIndexLifecyclePolicyAction",
                "org.elasticsearch.xpack.core.ilm.action.TransportStartILMAction",
                "org.elasticsearch.xpack.core.ilm.action.TransportStopILMAction",
                "org.elasticsearch.xpack.core.ml.action.TransportCloseJobAction",
                "org.elasticsearch.xpack.core.ml.action.TransportDeleteCalendarAction",
                "org.elasticsearch.xpack.core.ml.action.TransportDeleteCalendarEventAction",
                "org.elasticsearch.xpack.core.ml.action.TransportDeleteDatafeedAction",
                "org.elasticsearch.xpack.core.ml.action.TransportDeleteFilterAction",
                "org.elasticsearch.xpack.core.ml.action.TransportDeleteModelSnapshotAction",
                "org.elasticsearch.xpack.core.ml.action.TransportEstimateMemoryUsageAction",
                "org.elasticsearch.xpack.core.ml.action.TransportFinalizeJobExecutionAction",
                "org.elasticsearch.xpack.core.ml.action.TransportFindFileStructureAction",
                "org.elasticsearch.xpack.core.ml.action.TransportForecastJobAction",
                "org.elasticsearch.xpack.core.ml.action.TransportGetCalendarEventsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportGetCalendarsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportGetDatafeedsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportGetDatafeedsStatsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportGetDataFrameAnalyticsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportGetFiltersAction",

                //special, jobresultprovider
                "org.elasticsearch.xpack.core.ml.action.TransportGetInfluencersAction",
                "org.elasticsearch.xpack.ml.job.persistence.JobResultsProvider",

                "org.elasticsearch.xpack.core.ml.action.TransportGetJobsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportGetJobsStatsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportGetModelSnapshotsAction",

                //special,jobresultprovider
                "org.elasticsearch.xpack.core.ml.action.TransportGetRecordsAction",


                "org.elasticsearch.xpack.core.ml.action.TransportIsolateDatafeedAction",
                "org.elasticsearch.xpack.core.ml.action.TransportKillProcessAction",
                "org.elasticsearch.xpack.core.ml.action.TransportOpenJobAction",
                "org.elasticsearch.xpack.core.ml.action.TransportPersistJobAction",
                "org.elasticsearch.xpack.core.ml.action.TransportPostDataAction",
                "org.elasticsearch.xpack.core.ml.action.TransportPutCalendarAction",
                "org.elasticsearch.xpack.core.ml.action.TransportPutDatafeedAction",
                "org.elasticsearch.xpack.core.ml.action.TransportPutDataFrameAnalyticsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportPutJobAction",
                "org.elasticsearch.xpack.core.ml.action.TransportRevertModelSnapshotAction",
                "org.elasticsearch.xpack.core.ml.action.TransportSetUpgradeModeAction",
                "org.elasticsearch.xpack.core.ml.action.TransportStartDatafeedAction",
                "org.elasticsearch.xpack.core.ml.action.TransportStartDataFrameAnalyticsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportStopDatafeedAction",
                "org.elasticsearch.xpack.core.ml.action.TransportStopDataFrameAnalyticsAction",
                "org.elasticsearch.xpack.core.ml.action.TransportUpdateCalendarJobAction",
                "org.elasticsearch.xpack.core.ml.action.TransportUpdateDatafeedAction",
                "org.elasticsearch.xpack.core.ml.action.TransportUpdateJobAction",
                "org.elasticsearch.xpack.core.ml.action.TransportUpdateProcessAction",
                "org.elasticsearch.xpack.core.ml.action.TransportValidateDetectorAction",

                //special, reservedstorestore
//                "org.elasticsearch.xpack.core.monitoring.action.MonitoringBulkAction",
                "org.elasticsearch.xpack.core.security.authz.store.ReservedRolesStore",

                "org.elasticsearch.xpack.core.rollup.action.TransportDeleteRollupJobAction",

                //special, rollupindexcaps
//                "org.elasticsearch.xpack.core.rollup.action.GetRollupCapsAction",
                "org.elasticsearch.xpack.rollup.action.RollupIndexCaps",

                "org.elasticsearch.xpack.core.rollup.action.TransportGetRollupIndexCapsAction",
                "org.elasticsearch.xpack.core.rollup.action.TransportGetRollupJobsAction",
                "org.elasticsearch.xpack.core.rollup.action.TransportPutRollupJobAction",
                "org.elasticsearch.xpack.core.rollup.action.TransportRollupSearchAction",
                "org.elasticsearch.xpack.core.rollup.action.TransportStartRollupJobAction",
                "org.elasticsearch.xpack.core.rollup.action.TransportStopRollupJobAction",
                "org.elasticsearch.xpack.core.security.action.TransportCreateApiKeyAction",

                //special clusterprivilegeresolver
//                "org.elasticsearch.xpack.core.security.action.DelegatePkiAuthenticationAction",
                "org.elasticsearch.xpack.core.security.authz.privilege.ClusterPrivilegeResolver",

                //special, engine
                "org.elasticsearch.xpack.core.security.action.TransportGetApiKeyAction",


                "org.elasticsearch.xpack.core.security.action.TransportInvalidateApiKeyAction",
                "org.elasticsearch.xpack.core.security.action.oidc.TransportOpenIdConnectAuthenticateAction",
                "org.elasticsearch.xpack.core.security.action.oidc.TransportOpenIdConnectLogoutAction",
                "org.elasticsearch.xpack.core.security.action.oidc.TransportOpenIdConnectPrepareAuthenticationAction",
                "org.elasticsearch.xpack.core.security.action.privilege.TransportDeletePrivilegesAction",
                "org.elasticsearch.xpack.core.security.action.privilege.TransportGetBuiltinPrivilegesAction",
                "org.elasticsearch.xpack.core.security.action.realm.TransportClearRealmCacheAction",
                "org.elasticsearch.xpack.core.security.action.role.TransportClearRolesCacheAction",
                "org.elasticsearch.xpack.core.security.action.role.TransportDeleteRoleAction",
                "org.elasticsearch.xpack.core.security.action.role.TransportGetRolesAction",
                "org.elasticsearch.xpack.core.security.action.rolemapping.TransportPutRoleMappingAction",
                "org.elasticsearch.xpack.core.security.action.saml.TransportSamlAuthenticateAction",
                "org.elasticsearch.xpack.core.security.action.saml.TransportSamlInvalidateSessionAction",
                "org.elasticsearch.xpack.core.security.action.saml.TransportSamlLogoutAction",
                "org.elasticsearch.xpack.core.security.action.token.TransportCreateTokenAction",

                //special, clusterprivilegeresolver
                "org.elasticsearch.xpack.core.security.action.token.TransportInvalidateTokenAction",
//                "org.elasticsearch.xpack.core.security.action.token.RefreshTokenAction",

                //special, engine
                "org.elasticsearch.xpack.core.security.action.user.TransportAuthenticateAction",
//                "org.elasticsearch.xpack.core.security.action.user.ChangePasswordAction",
                "org.elasticsearch.xpack.core.security.action.user.TransportGetUserPrivilegesAction",



                "org.elasticsearch.xpack.core.security.action.user.TransportGetUsersAction",

                //special, clusterprivilegeresolver, engine
//                "org.elasticsearch.xpack.core.security.action.user.HasPrivilegesAction",

                "org.elasticsearch.xpack.core.security.action.user.TransportPutUserAction",
                "org.elasticsearch.xpack.core.slm.action.TransportDeleteSnapshotLifecycleAction",
                "org.elasticsearch.xpack.core.slm.action.TransportExecuteSnapshotLifecycleAction",
                "org.elasticsearch.xpack.core.slm.action.TransportExecuteSnapshotRetentionAction",
                "org.elasticsearch.xpack.core.slm.action.TransportGetSLMStatusAction",

                //special, clusterprivilegeresolver
                "org.elasticsearch.xpack.core.slm.action.TransportGetSnapshotLifecycleAction",

                "org.elasticsearch.xpack.core.slm.action.TransportGetSnapshotLifecycleStatsAction",
                "org.elasticsearch.xpack.core.slm.action.TransportPutSnapshotLifecycleAction",
                "org.elasticsearch.xpack.core.slm.action.TransportStartSLMAction",
                "org.elasticsearch.xpack.core.slm.action.TransportStopSLMAction",
                "org.elasticsearch.xpack.core.ssl.action.TransportGetCertificateInfoAction",
                "org.elasticsearch.xpack.core.transform.action.TransportDeleteTransformAction",
                "org.elasticsearch.xpack.core.transform.action.TransportGetTransformAction",
                "org.elasticsearch.xpack.core.transform.action.TransportGetTransformStatsAction",
                "org.elasticsearch.xpack.core.transform.action.TransportPreviewTransformAction",
                "org.elasticsearch.xpack.core.transform.action.TransportPutTransformAction",
                "org.elasticsearch.xpack.core.transform.action.TransportStartTransformAction",
                "org.elasticsearch.xpack.core.transform.action.TransportStopTransformAction",
                "org.elasticsearch.xpack.core.transform.action.TransportUpdateTransformAction",
                "org.elasticsearch.xpack.core.transform.action.compat.TransportDeleteTransformActionDeprecated",
                "org.elasticsearch.xpack.core.transform.action.compat.TransportGetTransformActionDeprecated",
                "org.elasticsearch.xpack.core.transform.action.compat.TransportGetTransformStatsActionDeprecated",
                "org.elasticsearch.xpack.core.transform.action.compat.TransportPreviewTransformActionDeprecated",
                "org.elasticsearch.xpack.core.transform.action.compat.TransportPutTransformActionDeprecated",
                "org.elasticsearch.xpack.core.transform.action.compat.TransportStartTransformActionDeprecated",
                "org.elasticsearch.xpack.core.transform.action.compat.TransportStopTransformActionDeprecated",
                "org.elasticsearch.xpack.core.transform.action.compat.TransportUpdateTransformActionDeprecated",
                "org.elasticsearch.xpack.core.watcher.transport.actions.ack.TransportAckWatchAction",
                "org.elasticsearch.xpack.core.watcher.transport.actions.execute.TransportExecuteWatchAction",
                "org.elasticsearch.xpack.core.watcher.transport.actions.put.TransportPutWatchAction",
                "org.elasticsearch.xpack.core.watcher.transport.actions.service.TransportWatcherServiceAction",
                "org.elasticsearch.xpack.core.watcher.transport.actions.stats.TransportWatcherStatsAction",
//                "org.elasticsearch.xpack.enrich.action.EnrichCoordinatorProxyAction", //subclass
                "org.elasticsearch.xpack.sql.plugin.TransportSqlStatsAction",
                "org.elasticsearch.xpack.sql.action.TransportSqlClearCursorAction",
                "org.elasticsearch.xpack.sql.action.TransportSqlTranslateAction",


                //special
                //Plugin RetentionLeaseActions
//                "org.elasticsearch.index.seqno.RetentionLeaseActions$Add",
//                "org.elasticsearch.index.seqno.RetentionLeaseActions$Renew",
//                "org.elasticsearch.index.seqno.RetentionLeaseActions$Remove",
                "org.elasticsearch.xpack.core.security.authz.privilege.SystemPrivilege",

                //special, Test
                //Plugin ActionModuleTests
//                "org.elasticsearch.action.ActionModuleTests$3FakeAction",
                //Plugin ActionTests
//                "org.elasticsearch.action.ActionTests$1FakeAction",

                //special, in TestTaskPlugin
                //Plugin TestTaskPlugin
                "org.elasticsearch.action.admin.cluster.node.tasks.TestTaskPlugin",
//                "org.elasticsearch.action.admin.cluster.node.tasks.TestTaskPlugin$TestTaskAction",
//                "org.elasticsearch.action.admin.cluster.node.tasks.TestTaskPlugin$UnblockTestTasksAction",

                //special, "Transport" in the same class
                //Plugin InternalOrPrivateSettingsPlugin
                "org.elasticsearch.indices.settings.InternalOrPrivateSettingsPlugin$TransportUpdateInternalOrPrivateAction",
//                "org.elasticsearch.indices.settings.InternalOrPrivateSettingsPlugin$UpdateInternalOrPrivateAction",
                //Plugin TestPersistentTasksPlugin
                "org.elasticsearch.persistent.TestPersistentTasksPlugin$TransportTestTaskAction",
//                "org.elasticsearch.persistent.TestPersistentTasksPlugin$TestTaskAction",

        };
    }


}
