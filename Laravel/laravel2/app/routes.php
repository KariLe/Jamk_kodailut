<?php

/*
|--------------------------------------------------------------------------
| Application Routes
|--------------------------------------------------------------------------
|
| Here is where you can register all of the routes for an application.
| It's a breeze. Simply tell Laravel the URIs it should respond to
| and give it the Closure to execute when that URI is requested.
|
*/

Route::get('/', 'HomeController@showWelcome');

// Authentication
Route::get('login', array('as' => 'login', 'uses' => 'AuthController@showLogin'));
Route::post('login', 'AuthController@postLogin');
Route::get('logout', 'AuthController@getLogout');

//wikin routet
Route::get('wiki', function() { return Redirect::to('wiki/Home'); });
Route::get('wiki/{page}', 'WikiController@showPage');
Route::get('docs', function() { return Redirect::to('docs/Start'); });
Route::get('docs/{page}', 'DocsWikiController@showPage');

//IoC tässä ja
$app->bind('WikiController', function($app) {
    $repository = new WikipageRepository;
    $repository->setDatapath(base_path() . '/wiki');

    return new WikiController($repository);
});
//tässä
$app->bind('DocsWikiController', function($app) {
    $repository = new WikipageRepository;
    $repository->setDatapath(base_path() . '/docs');

    return new WikiController($repository);
});

// Secure-Routes
Route::group(array('before' => 'auth'), function()
{
    Route::get('secret', 'HomeController@showSecret');
});