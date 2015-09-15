@extends('layouts.master')

@section('title')
@parent
:: Wiki - {{ $page->title }}
@stop

@section('content')
    <div class="container">
        {{ $page->content }}
    </div>
@stop
