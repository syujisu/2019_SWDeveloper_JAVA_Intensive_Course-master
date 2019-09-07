#include <stdio.h>
#include <stdlib.h>
// 과제 : 이 파일을 분석해서 java와 비교해서 리포트 작성. 함수 하나의 길이가 크다고 해서 인스턴스를 많이 생성하면
//메모리에 부담이가는지?? 결론은 No! 그럼 이유는 무엇인가....?
typedef struct apple {
	int data;
	void (*print)( void* );
}Apple;

typedef struct pine_apple {
	int data;
	void (*print)( void* );

	float pi;
	int (*increase)( void* , int i );
}PineApple;

void apple_constructor( void* self , int data ) 
{
	Apple* this = (Apple*)self;
	this->data  = data;
}

void pine_apple_constructor( void* self , int data ) 
{
	PineApple* this = (PineApple*)self;
	this->pi = 3.14;
}

void apple_print( void* self )
{
	Apple* this = (Apple*)self;
	printf("Apple %d\n" , this->data );
}

void pine_apple_print( void* self )
{
	PineApple* this = (PineApple*)self;
	printf("PineApple %d : %f\n", this->data, this->pi );
}

int pine_apple_increase( void* self, int i )
{
	PineApple* this = (PineApple*)self;
	printf("%f\n", this-> pi );
	
	return ( this->data + i );
}

Apple* new_Apple( int data ){
	Apple* new;
	new = (Apple*)malloc( sizeof(Apple) );
	
	new->print = apple_print;

	apple_constructor( new, data );

	return new;
}

PineApple* new_PineApple( int data ){
	PineApple* new;
	new = (PineApple*)malloc( sizeof(PineApple) );
	
	new->print = apple_print;

	new->increase = pine_apple_increase;
	new->print = pine_apple_print;

	apple_constructor( new, data );
	pine_apple_constructor( new, data );

	return new;
}

int main()
{
	Apple* t;
	
	t = (Apple*)new_PineApple( 100 );
	t->print( t );
	
	free( t );

	return 0;
}

