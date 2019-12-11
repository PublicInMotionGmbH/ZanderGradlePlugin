import com.android.build.gradle.api.*
import com.android.build.gradle.api.JavaCompileOptions
import com.android.build.gradle.tasks.*
import com.android.builder.model.*
import org.gradle.api.DefaultTask
import org.gradle.api.DomainObjectCollection
import org.gradle.api.Task
import org.gradle.api.artifacts.ArtifactCollection
import org.gradle.api.artifacts.Configuration
import org.gradle.api.file.ConfigurableFileTree
import org.gradle.api.file.FileCollection
import org.gradle.api.resources.TextResource
import org.gradle.api.tasks.AbstractCopyTask
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.compile.JavaCompile
import java.io.File

class FakeVariant(private val givenName: String = "", private val givenApplicationId: String = "") :
    ApplicationVariant {
    override fun getDirName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMergeResourcesProvider(): TaskProvider<MergeResources> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompileConfiguration(): Configuration {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPackageApplication(): PackageAndroidArtifact {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerGeneratedBytecode(fileCollection: FileCollection?): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProcessJavaResourcesProvider(): TaskProvider<AbstractCopyTask> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAnnotationProcessorConfiguration(): Configuration {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getObfuscation(): Task {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVersionName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompileClasspath(key: Any?): FileCollection {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNdkCompile(): NdkCompile {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNdkCompileProvider(): TaskProvider<NdkCompile> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSigningConfig(): SigningConfig {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getApplicationId(): String {
        return givenApplicationId
    }

    override fun register(task: Task?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDescription(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCheckManifestProvider(): TaskProvider<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUninstall(): DefaultTask {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setTestVariant(testVariant: TestVariant?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPreBuild(): Task {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSourceSets(): MutableList<SourceProvider> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJavaCompileOptions(): JavaCompileOptions {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMappingFile(): File {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOutputs(): DomainObjectCollection<BaseVariantOutput> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerPreJavacGeneratedBytecode(fileCollection: FileCollection?): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPackageApplicationProvider(): TaskProvider<PackageAndroidArtifact> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProcessJavaResources(): AbstractCopyTask {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerExternalAptJavaOutput(folder: ConfigurableFileTree?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBuildType(): BuildType {
        return object : BuildType {
            override fun getMultiDexEnabled(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getName(): String {
                return givenName
            }

            override fun getManifestPlaceholders(): MutableMap<String, Any> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isZipAlignEnabled(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getTestProguardFiles(): MutableCollection<File> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getMultiDexKeepProguard(): File {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isEmbedMicroApp(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isTestCoverageEnabled(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getSigningConfig(): SigningConfig {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isPseudoLocalesEnabled(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getVersionNameSuffix(): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getApplicationIdSuffix(): String {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getRenderscriptOptimLevel(): Int {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isMinifyEnabled(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isDebuggable(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getBuildConfigFields(): MutableMap<String, ClassField> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getConsumerProguardFiles(): MutableCollection<File> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getMultiDexKeepFile(): File {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getProguardFiles(): MutableCollection<File> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getResValues(): MutableMap<String, ClassField> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isRenderscriptDebuggable(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun isJniDebuggable(): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    override fun isSigningReady(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setOutputsAreSigned(isSigned: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerJavaGeneratingTask(task: Task?, vararg sourceFolders: File?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerJavaGeneratingTask(task: Task?, sourceFolders: MutableCollection<File>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRenderscriptCompileProvider(): TaskProvider<RenderscriptCompile> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun missingDimensionStrategy(dimension: String?, requestedValue: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun missingDimensionStrategy(dimension: String?, vararg requestedValues: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun missingDimensionStrategy(dimension: String?, requestedValues: MutableList<String>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInstallProvider(): TaskProvider<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getDex(): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMergedFlavor(): ProductFlavor {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getApplicationIdTextResource(): TextResource {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTestVariant(): TestVariant {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInstall(): DefaultTask {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAssemble(): Task {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAidlCompile(): AidlCompile {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOutputsAreSigned(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJavaCompiler(): Task {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUninstallProvider(): TaskProvider<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSourceFolders(folderType: SourceKind?): MutableList<ConfigurableFileTree> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProductFlavors(): MutableList<ProductFlavor> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllRawAndroidResources(): FileCollection {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAidlCompileProvider(): TaskProvider<AidlCompile> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getPreBuildProvider(): TaskProvider<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFlavorName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJavaCompileProvider(): TaskProvider<JavaCompile> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCheckManifest(): Task {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMergeAssets(): MergeSourceSetFolders {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUnitTestVariant(): UnitTestVariant {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMergeResources(): MergeResources {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompatibleScreens(): MutableSet<String> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRuntimeConfiguration(): Configuration {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCompileClasspathArtifacts(key: Any?): ArtifactCollection {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun buildConfigField(type: String?, name: String?, value: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resValue(type: String?, name: String?, value: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getJavaCompile(): JavaCompile {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerPostJavacGeneratedBytecode(fileCollection: FileCollection?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addJavaSourceFoldersToModel(vararg sourceFolders: File?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addJavaSourceFoldersToModel(sourceFolders: MutableCollection<File>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setUnitTestVariant(testVariant: UnitTestVariant?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getExternalNativeBuildTasks(): MutableCollection<ExternalNativeBuildTask> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMergeAssetsProvider(): TaskProvider<MergeSourceSetFolders> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGenerateBuildConfig(): GenerateBuildConfig {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getVersionCode(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getExternalNativeBuildProviders(): MutableCollection<TaskProvider<ExternalNativeBuildTask>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerGeneratedResFolders(folders: FileCollection?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRenderscriptCompile(): RenderscriptCompile {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBaseName(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getGenerateBuildConfigProvider(): TaskProvider<GenerateBuildConfig> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAssembleProvider(): TaskProvider<Task> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerResGeneratingTask(task: Task?, vararg resFolders: File?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerResGeneratingTask(task: Task?, resFolders: MutableCollection<File>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
