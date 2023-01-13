//引入gulp和gulp插件
var gulp = require('gulp');
var	rev = require('gulp-rev');
var	revCollector = require('gulp-rev-collector');
//var del = require('del');
//项目的新路径

//定义css、js文件路径，是本地css,js文件的路径，可自行配置

var jsUrl = '../clp-web/src/main/webapp/static/js/**/*.js';
var jsDestUrl = '../clp-web/src/main/webapp/static/js/';
//var jsBackupUrl = './js/';
//var jsRestoreUrl = './js/**/*.js';
var srcUrl = '../clp-web/src/main/webapp/WEB-INF/templates/**/*.html';
var destUrl = '../clp-web/src/main/webapp/WEB-INF/templates/';
//var backupUrl = './templates/';
//var restoreUrl = './templates/**/*.html';

/*
gulp.task('backupJs', function(){
	return gulp.src(jsUrl)
	        .pipe(gulp.dest(jsBackupUrl));
});

gulp.task('backupHtml', function(){
	return gulp.src(srcUrl)
	        .pipe(gulp.dest(backupUrl));
});

gulp.task('backup', gulp.series('backupJs', 'backupHtml'));

gulp.task('restoreJs', function(){
	(async () => {
		const deletedPaths = await del([jsUrl]);
		console.log('Deleted files and folders:\n', deletedPaths.join('\n'));
	})();
	return gulp.src(jsRestoreUrl)
		.pipe(gulp.dest(jsDestUrl));
});

gulp.task('restoreHtml', function(){
	(async () => {
		const deletedPaths = await del([srcUrl]);
		console.log('Deleted files and folders:\n', deletedPaths.join('\n'));
	})();
	return gulp.src(restoreUrl)
		.pipe(gulp.dest(destUrl));
});
 
 gulp.task('restore', gulp.series('restoreJs', 'restoreHtml'));
 
 gulp.task('rmHtmlBackup', function(){
	(async () => {
		const deletedPaths = await del([restoreUrl, backupUrl]);
		console.log('Deleted files and folders:\n', deletedPaths.join('\n'));
	})();
	return ;
 });
 
 gulp.task('rmJsBackup', function(){
	(async () => {
		const deletedPaths = await del([jsRestoreUrl, jsBackupUrl]);
		console.log('Deleted files and folders:\n', deletedPaths.join('\n'));
	})();
	return ;
 });
 
 gulp.task('rmBackup', gulp.series('rmHtmlBackup', 'rmJsBackup'));
*/ 
 
//js生成文件hash编码并生成 rev-manifest.json文件名对照映射
gulp.task('revJs', function(){
	return gulp.src(jsUrl)        
		   .pipe(rev())
		   .pipe(gulp.dest(jsDestUrl))
		   .pipe(rev.manifest())        
		   .pipe(gulp.dest('rev/js'));
});


 //Html更换css、js文件版本
gulp.task('revHtml', function () {
	return gulp.src(['rev/**/*.json', srcUrl])         
		   .pipe(revCollector())        
		   .pipe(gulp.dest(destUrl)); 
 });

//开发构建
gulp.task('default', gulp.series('revJs', 'revHtml'));



